package com.deleveryboy.service;

import com.deleveryboy.config.AppConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class KafkaService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    private Logger logger = LoggerFactory.getLogger(KafkaService.class);

    public KafkaService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public boolean UpdateLocation(String location) {
        this.kafkaTemplate.send(AppConstant.LOCATION_TOPIC_NAME, location);
        logger.info("message sent to kafka topic");
        return true;
    }
}
