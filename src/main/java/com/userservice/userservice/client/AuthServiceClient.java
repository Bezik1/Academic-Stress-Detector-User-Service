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
                    .exchangeToMono(resp -> {
                        if (resp.statusCode().is2xxSuccessful()) {
                            return resp.bodyToMono(ValidationResponse.class);
                        } else if (resp.statusCode().value() == 401) {
                            throw new RuntimeException("Unauthorized token");
                        } else {
                            return resp.bodyToMono(String.class)
                                    .map(body -> { throw new RuntimeException("Auth service error: " + resp.statusCode() + " " + body); });
                        }
                    })
                    .block();
        } catch (Exception e) {
            throw new RuntimeException("Failed to call auth service validate endpoint", e);
        }
    }

}