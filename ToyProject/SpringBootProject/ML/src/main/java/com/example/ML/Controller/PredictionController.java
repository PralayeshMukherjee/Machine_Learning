package com.example.ML.Controller;

import com.example.ML.DTO.PredictionRequestDTO;
import com.example.ML.Service.PredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class PredictionController {
    @Autowired
    private PredictionService predictionService;
    public ResponseEntity<Map<String,Integer>> getPrediction(@RequestBody PredictionRequestDTO predictionRequestDTO){
        double iq = predictionRequestDTO.getIq();
        double cgpa = predictionRequestDTO.getCgpa();
    }
}
