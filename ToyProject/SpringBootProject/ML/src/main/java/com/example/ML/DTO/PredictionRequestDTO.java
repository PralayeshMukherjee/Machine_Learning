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

    public double getIq() {
        return iq;
    }

    public void setIq(double iq) {
        this.iq = iq;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }
}
