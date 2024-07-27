package com.deleveryboy.controller;


import com.deleveryboy.service.KafkaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class LocationController {

    public final KafkaService kafkaService;

    public LocationController(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateLocation() {
        int latitude = (int) (Math.random() * 100);
        int longitude = (int) (Math.random() * 100);
        String location = "(" + latitude + ", " + longitude + ")";
        kafkaService.UpdateLocation(location);
        return new ResponseEntity<>(Map.of("message", "location-updated"), HttpStatus.OK);
    }

}
