package com.userservice.userservice.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.userservice.userservice.dto.ValidationResponse;

@Component
public class AuthServiceClient {

    private final WebClient webClient;

    public AuthServiceClient(WebClient authServiceWebClient) {
        this.webClient = authServiceWebClient;
    }

    public ValidationResponse validateToken(String token) {
        return webClient.get()
                .uri("/auth/validate")
                .header("Authorization", "Bearer " + token)
                .retrieve()
                .bodyToMono(ValidationResponse.class)
                .block();
    }
}