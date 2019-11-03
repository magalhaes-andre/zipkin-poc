package com.magalhaes.sleuth.scrambling_service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ServiceConfiguration {
    @Value("${capitalizing.service.uri}")
    private String capitalizingServiceUri;

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public String getCapitalizingServiceUri(){
        return this. capitalizingServiceUri;
    }
}
