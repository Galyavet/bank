package com.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class CardDTO {

    private String cardNumber;

    private int pinCode;

    private double balance;
}
