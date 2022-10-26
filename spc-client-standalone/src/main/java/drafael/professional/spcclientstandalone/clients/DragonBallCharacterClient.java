package drafael.professional.spcclientstandalone.clients;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "drafael-dragon-ball")
@LoadBalancerClient(name = "drafael-dragon-ball", configuration = DrafaelLoadBalancerConfiguration.class)
public interface DragonBallCharacterClient {

    @RequestMapping(method = RequestMethod.GET, value = "/example")
    public ResponseEntity<String> getApplicationName();
}