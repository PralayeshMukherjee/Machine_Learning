package com.example.ML.Service;

import com.example.ML.DTO.PredictionRequestDTO;
import com.example.ML.DTO.PredictionResponseDTO;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

public class PredictionService {
    public int getPrediction(double iq,double cgpa){
        PredictionRequestDTO predictionRequestDTO = new PredictionRequestDTO(iq,cgpa);
        String url = "http://localhost:5000";
        WebClient webClient = WebClient.create(url);
        String response = webClient.post()
                .uri("/predict")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(predictionRequestDTO)
                .retrieve()
                .bodyToMono(PredictionResponseDTO.class)
    }
}
