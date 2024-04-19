package com.gabriel.paymentservice.services.impl;

import com.gabriel.paymentservice.model.Payment;
import com.gabriel.paymentservice.services.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
@Log4j2
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final KafkaTemplate<String, Serializable> kafkaTemplate;

    @Override
    public void sendPayment(Payment payment) {
        log.info("Recebido {}", payment);
        kafkaTemplate.send("payment-topic", payment);
    }
}
