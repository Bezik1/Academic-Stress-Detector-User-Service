package com.userservice.userservice.client;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.userservice.userservice.dto.ValidationResponse;

@Component
public class AuthServiceClient {

    private final WebClient webClient;

    public AuthServiceClient(@Qualifier("authServiceWebClient") WebClient authServiceWebClient) {
        this.webClient = authServiceWebClient;
    }

    public ValidationResponse validateToken(String token) {
        try {
            return webClient.get()
                    .uri("/auth/validate")
                    .header("Authorization", "Bearer " + token)
                    .retrieve()
                    .onStatus(status -> status.is4xxClientError() || status.is5xxServerError(),
                                resp -> resp.bodyToMono(String.class).map(body -> new RuntimeException("Auth service error: " + resp.statusCode() + " " + body)))
                    .bodyToMono(ValidationResponse.class)
                    .block();
        } catch (Exception e) {
            throw new RuntimeException("Failed to call auth service validate endpoint", e);
        }
    }
}