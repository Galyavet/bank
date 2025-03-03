package com.spring.bank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Card extends CommonModel {

    private String cardNumber;
    private Integer pinCode;
    private Double balance;

    public Card(Long id, String cardNumber, Integer pinCode, Double balance) {
        this.setId(id);
        this.cardNumber = cardNumber;
        this.pinCode = pinCode;
        this.balance = balance;
    }

    public String reformatCardNumber() {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 16; i += 4) {
            list.add(cardNumber.substring(i, i + 4));
        }
        return String.join("-", list);
    }
}
