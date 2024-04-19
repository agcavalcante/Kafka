package com.gabriel.paymentconsumer.listeners;

import com.gabriel.paymentconsumer.model.Payment;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Log4j2
@RequiredArgsConstructor
public class JsonListener {

    @KafkaListener(topics = "payment-topic", groupId = "createGroup", containerFactory = "kafkaListenerContainerFactory")
    public void antiFraud(@Payload Payment payment) {
        log.info("RECEBI O PAGAMENTO ::: {}", payment.toString());
    }
}
