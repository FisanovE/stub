package com.example.stub.service;

import com.example.stub.model.MessageToKafka;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private final KafkaTemplate<String, MessageToKafka> kafkaTemplate;

    public CompletableFuture<SendResult<String, MessageToKafka>> sendMessage(MessageToKafka message) {
        return kafkaTemplate.send("postedmessages", message);
    }
}
