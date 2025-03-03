package com.spring.bank.commands.impl;

import com.spring.bank.commands.Command;
import com.spring.bank.service.CardService;

public class PutMoneyCommand implements Command {
    private final CardService cardService;

    public PutMoneyCommand(CardService cardService) {
        this.cardService = cardService;
    }

    @Override
    public void execute(Object... args) {
        Long cardId = (Long) args[0];
        double amount = (double) args[1];

        try {
            cardService.putMoney(cardId, amount);
            System.out.println("Операция выполнена успешно.");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
