package com.example.ML.Controller;

import com.example.ML.DTO.PredictionRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class PredictionController {
    public ResponseEntity<Map<String,Integer>> getPrediction(@RequestBody PredictionRequestDTO predictionRequestDTO){

    }
}
