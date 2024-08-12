package com.example.stub.service;

import com.example.stub.model.MessageToKafka;
import com.example.stub.model.RequestMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageService {

    private final KafkaProducerService producerService;
    private final ObjectMapper objectMapper;

    public boolean sendMessage(RequestMessage message) {
        try {
            long timestamp = Instant.now().toEpochMilli();

            MessageToKafka messageToKafka = new MessageToKafka();
            messageToKafka.setId(message.getId());
            messageToKafka.setTimestamp(String.valueOf(timestamp));
            messageToKafka.setMethod("POST");
            messageToKafka.setUri("/post-message");

            CompletableFuture<SendResult<String, MessageToKafka>> future = producerService.sendMessage(messageToKafka);
            future.orTimeout(1000, TimeUnit.MILLISECONDS);
            return true;
        } catch (Exception e) {
            log.info(e.getMessage());
            return false;
        }
    }
}
