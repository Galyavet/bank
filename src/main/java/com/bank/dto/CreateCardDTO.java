package com.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateCardDTO {
    private String cardNumber;
    private int pinCode;
    private double balance;
}
