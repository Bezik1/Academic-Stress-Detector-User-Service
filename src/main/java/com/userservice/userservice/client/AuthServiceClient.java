package com.userservice.userservice.client;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.userservice.userservice.dto.ValidationResponse;

@Component
public class AuthServiceClient {
    private final WebClient webClient;

    public AuthServiceClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public ValidationResponse validateToken(String token) {
        return webClient.get()
                .uri("/auth/validate")
                .header("Authorization", "Bearer " + token)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<ValidationResponse>() {})
                .block();
    }
}
