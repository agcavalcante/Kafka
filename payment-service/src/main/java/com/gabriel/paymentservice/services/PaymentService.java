package com.gabriel.paymentservice.services;

import com.gabriel.paymentservice.model.Payment;

public interface PaymentService {

    void sendPayment(Payment payment);
}
