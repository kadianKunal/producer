package com.producer.producer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static com.producer.producer.config.Constants.KAFKA_TOPIC_NAME;

@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private final Logger log = LoggerFactory.getLogger(KafkaService.class);

    public boolean produceMessage(String message) {
        kafkaTemplate.send(KAFKA_TOPIC_NAME, message);
        log.info("Msg produced");
        return true;
    }
}
