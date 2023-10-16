package com.producer.producer.controller;

import com.producer.producer.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private KafkaService kafkaService;

    @PostMapping("/send")
    public ResponseEntity<?> sendMessage() {

        for(int i=1; i<=1000000; i++) {
            this.kafkaService.produceMessage(String.valueOf(Math.floor(Math.random()*1000)));
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
