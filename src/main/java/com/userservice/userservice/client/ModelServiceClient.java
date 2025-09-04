package com.userservice.userservice.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import com.userservice.userservice.dto.StressInputDto;
import java.util.Map;

@Component
public class ModelServiceClient {
    private final WebClient webClient;

    public ModelServiceClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Map<String, Object> predictStress(StressInputDto input) {
        return webClient.post()
                .uri("http://127.0.0.1:8000/api/model/predict")
                .bodyValue(input)
                .retrieve()
                .bodyToMono(Map.class)
                .block();
    }
}