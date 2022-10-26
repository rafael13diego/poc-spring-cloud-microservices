package com.drafael.professional.spcspringgateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class GatewayConfig {
//Business rules to routing/redirect
    @Bean
    @Profile("localhostRouter-noEureka")
    public RouteLocator configLocalNoEureka(RouteLocatorBuilder builder){


        return builder.routes()
                .route(r -> r.path("/api/v1/dragonball/*")
                        .uri("http://localhost:8082"))
                .route(r -> r.path("/api/v1/got/*")
                        .uri("http://localhost:8083"))
                .build();
    }

    @Bean
    @Profile("localhostRouter-eureka")
    public RouteLocator configLocalEureka(RouteLocatorBuilder builder){

        return builder.routes()
                .route(r -> r.path("/api/v1/dragonball/*")
                        .uri("lb://drafael-dragon-ball"))
                .route(r -> r.path("/api/v1/got/*")
                        .uri("lb://drafael-game-of-thrones"))
                .build();
    }

    @Bean
    @Profile("localhostRouter-eureka-cb")
    public RouteLocator configLocalEurekaCB(RouteLocatorBuilder builder){

        return builder.routes()
                .route(r -> r.path("/api/v1/dragonball/*")
                        .filters(f -> f.circuitBreaker(c -> c.setName("failLoverCB")
                                .setFallbackUri("foward:/api/v1/dragonball-fl/characters")
                                .setRouteId("drafael-dbz-faillover")))
                        .uri("lb://drafael-dragon-ball"))
                .route(r -> r.path("/api/v1/got/*")
                        .uri("lb://drafael-game-of-thrones"))
                .route(r -> r.path("/api/v1/dragonball-fl/*")
                        .uri("lb://drafael-dbz-faillover"))
                .build();
    }
}