package com.example.ML.Controller;

import com.example.ML.DTO.PredictionRequestDTO;
import com.example.ML.Service.PredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:5173")
public class PredictionController {
    @Autowired
    private PredictionService predictionService;
    @PostMapping("/prediction")
    public ResponseEntity<Map<String,Integer>> getPrediction(@RequestBody PredictionRequestDTO predictionRequestDTO){
        float iq = predictionRequestDTO.getIq();
        float cgpa = predictionRequestDTO.getCgpa();
        int response = predictionService.getPrediction(iq,cgpa);
        return ResponseEntity.ok(Map.of("prediction",response));
    }
}
