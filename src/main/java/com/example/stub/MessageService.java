package com.example.stub;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.time.Instant;
import java.util.concurrent.CompletableFuture;

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
            messageToKafka.setId(message.getMsg_id());
            messageToKafka.setTimestamp(String.valueOf(timestamp));
            messageToKafka.setMethod("POST");
            messageToKafka.setUri("/post-message");

            String jsonMessage = objectMapper.writeValueAsString(messageToKafka);
            CompletableFuture<SendResult<String, String>> future = producerService.sendMessage(jsonMessage);
            System.out.println(future.get());
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }
}
