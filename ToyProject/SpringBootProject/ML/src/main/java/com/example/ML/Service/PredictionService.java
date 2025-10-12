package com.example.ML.Service;

import org.springframework.web.reactive.function.client.WebClient;

public class PredictionService {
    String url = "http://localhost:5000/predict";
    WebClient webClient = WebClient.create(url);
    String response = webClient.post()
            .uri("/predict")
}
