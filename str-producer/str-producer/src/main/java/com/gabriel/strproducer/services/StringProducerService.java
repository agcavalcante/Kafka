package com.gabriel.strproducer.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
@Slf4j
public class StringProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        //kafkaTemplate.send("str-topic", message);
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send("str-topic", message);
        future.whenComplete((r, e) -> {
            if (e != null) {
                log.info(e.getMessage());
            } else {
                log.info("Message {} sent to partition {} with offset {}", message, r.getRecordMetadata().partition(), r.getRecordMetadata().offset());
            }
        });
    }
}
