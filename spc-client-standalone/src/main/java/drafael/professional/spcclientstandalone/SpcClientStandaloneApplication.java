package drafael.professional.spcclientstandalone;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import drafael.professional.spcclientstandalone.clients.DragonBallCharacterClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootApplication
@EnableFeignClients
@Slf4j
public class SpcClientStandaloneApplication implements ApplicationRunner {

    @Autowired
    private DragonBallCharacterClient dragonBallClient;

    @Autowired
    private EurekaClient eurekaClient;

    public static void main(String[] args) {
        SpringApplication.run(SpcClientStandaloneApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        for (int i = 0; i < 10; i++) {
            ResponseEntity<String> responseEntity = dragonBallClient.getApplicationName();
            log.info("Status {}", responseEntity.getStatusCode());
            String body = responseEntity.getBody();
            log.info("Body: {}", body);
        }
    }

    /**
     * Implementación de cliente Eureka
     * @param args
     * @throws Exception

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Application application = eurekaClient.getApplication("drafael-dragon-ball");
        log.info("Application Namee: " + application.getName());

        application.getInstances().forEach(instance -> {
            log.info("IP address {}:{}", instance.getIPAddr(), instance.getPort());
        });
        //application.getInstances().stream().forEach( instance -> {log.info("IP address {}:{}", instance.getIPAddr(), instance.getPort());});
    }
    **/

}