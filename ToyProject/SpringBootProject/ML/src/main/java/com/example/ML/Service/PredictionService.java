package com.example.ML.Service;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

public class PredictionService {
    public int getPrediction(double iq,double cgpa){
        String url = "http://localhost:5000";
        WebClient webClient = WebClient.create(url);
        String response = webClient.post()
                .uri("/predict")
                .contentType(MediaType.APPLICATION_JSON)
    }
}
