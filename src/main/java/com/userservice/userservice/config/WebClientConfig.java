package com.userservice.userservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient modelServiceWebClient() {
        return WebClient.builder()
                .baseUrl("http://127.0.0.1:8000")
                .build();
    }

    @Bean
    public WebClient authServiceWebClient() {
        return WebClient.builder()
                .baseUrl("https://academic-stress-detector-auth-service.onrender.com")
                .build();
    }
}