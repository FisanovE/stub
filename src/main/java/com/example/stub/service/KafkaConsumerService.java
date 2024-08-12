package com.example.stub.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerService {
    @KafkaListener(topics = "postedmessages")
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
    }
}
