package com.example.ML.DTO;

public class PredictionRequestDTO {
    private double iq;
    private double cgpa;

    public PredictionRequestDTO() {
    }

    public PredictionRequestDTO(double iq, double cgpa) {
        this.iq = iq;
        this.cgpa = cgpa;
    }
}
