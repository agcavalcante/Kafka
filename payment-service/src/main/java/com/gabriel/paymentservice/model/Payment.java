package com.gabriel.paymentservice.model;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class Payment implements Serializable {

    private Long id;
    private Long userId;
    private Long idProduct;
    private String cardNumber;
}
