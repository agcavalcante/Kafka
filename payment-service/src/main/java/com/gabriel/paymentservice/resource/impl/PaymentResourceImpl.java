package com.gabriel.paymentservice.resource.impl;


import com.gabriel.paymentservice.model.Payment;
import com.gabriel.paymentservice.resource.PaymentResource;
import com.gabriel.paymentservice.services.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
@RequiredArgsConstructor
public class PaymentResourceImpl implements PaymentResource {

    private final PaymentService paymentService;

    @Override
    public ResponseEntity<Payment> createPayment(Payment payment) {
        paymentService.sendPayment(payment);
        return ResponseEntity.status(HttpStatus.CREATED).body(payment);
    }
}
