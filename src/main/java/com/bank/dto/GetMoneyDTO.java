package com.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetMoneyDTO {
    private Long cardId;
    private double amount;
}
