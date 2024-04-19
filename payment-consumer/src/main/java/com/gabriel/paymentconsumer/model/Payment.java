package com.gabriel.paymentconsumer.model;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class Payment implements Serializable {

    private Long id;
    private Long userId;
    private Long idProduct;
    private String cardNumber;

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", userId=" + userId +
                ", idProduct=" + idProduct +
                ", cardNumber='" + cardNumber + '\'' +
                '}';
    }
}
