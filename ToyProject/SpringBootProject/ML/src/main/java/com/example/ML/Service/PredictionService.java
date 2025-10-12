package com.example.ML.Service;

import com.example.ML.DTO.PredictionRequestDTO;
import com.example.ML.DTO.PredictionResponseDTO;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class PredictionService {
    public int getPrediction(float iq,float cgpa){
        PredictionRequestDTO predictionRequestDTO = new PredictionRequestDTO(iq,cgpa);
        String url = "http://localhost:5000";
        WebClient webClient = WebClient.create(url);
        try{
            PredictionResponseDTO response = webClient.post()
                    .uri("/predict")
                    .contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(predictionRequestDTO)
                    .retrieve()
                    .bodyToMono(PredictionResponseDTO.class)
                    .block();
            return response.getPrediction();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
