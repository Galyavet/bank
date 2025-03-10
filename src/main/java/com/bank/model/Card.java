package com.bank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    private Long id;

    private String cardNumber;

    private Integer pinCode;

    private Double balance;

    public String reformatCardNumber() {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 16; i += 4) {
            list.add(cardNumber.substring(i, i + 4));
        }
        return String.join("-", list);
    }
}
