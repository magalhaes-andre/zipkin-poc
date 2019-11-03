package com.magalhaes.sleuth.sorting_service.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@Getter
public class ServiceConfiguration {

    @Value("${scrambling_service_uri}")
    private String SCRAMBLING_SERVICE_URI;

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    } 
}
