package com.example.ML.DTO;

public class PredictionRequestDTO {
    private float iq;
    private float cgpa;

    public PredictionRequestDTO() {
    }

    public PredictionRequestDTO(float iq, float cgpa) {
        this.iq = iq;
        this.cgpa = cgpa;
    }

    public float getIq() {
        return iq;
    }

    public void setIq(float iq) {
        this.iq = iq;
    }

    public float getCgpa() {
        return cgpa;
    }

    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }
}
