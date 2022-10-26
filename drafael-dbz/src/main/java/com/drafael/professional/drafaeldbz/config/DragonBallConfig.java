package com.drafael.professional.drafaeldbz.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties
@RefreshScope // if updated the file config server, it will refresh here
public class DragonBallConfig {

    @Value("${application.name}")
    //@Getter @Setter
    private String applicationName;

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }
}