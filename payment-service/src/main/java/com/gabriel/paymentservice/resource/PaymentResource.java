package com.gabriel.paymentservice.resource;

import com.gabriel.paymentservice.model.Payment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface PaymentResource {

    @PostMapping
    ResponseEntity<Payment> createPayment(@RequestBody Payment payment);
}
