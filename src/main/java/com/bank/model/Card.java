package com.bank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    private Long id;

    private String cardNumber;

    private Integer pinCode;

    private Double balance;

}
