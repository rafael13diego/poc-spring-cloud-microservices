package drafael.professional.spcclientstandalone.clients;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class DrafaelLoadBalancerConfiguration {

    @Bean
    public ServiceInstanceListSupplier discoveryClientServiceInstanceListSupplier(
            ConfigurableApplicationContext context) {
        log.info("Configuring Load balancer to prefer same instance");
        return ServiceInstanceListSupplier.
                builder()
                .withBlockingDiscoveryClient()
                //.withSameInstancePreference()
                .build(context);
    }
}