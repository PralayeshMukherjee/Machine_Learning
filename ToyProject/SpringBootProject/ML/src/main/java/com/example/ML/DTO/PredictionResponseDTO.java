package com.example.ML.DTO;

public class PredictionResponseDTO {
    private int prediction;

    public PredictionResponseDTO(int prediction) {
        this.prediction = prediction;
    }

    public PredictionResponseDTO() {
    }

    public int getPrediction() {
        return prediction;
    }

    public void setPrediction(int prediction) {
        this.prediction = prediction;
    }
}
