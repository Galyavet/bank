package com.spring.bank.commands.impl;

import com.spring.bank.commands.Command;
import com.spring.bank.model.Card;
import com.spring.bank.service.CardService;

public class CreateCardCommand implements Command {
    private final CardService cardService;

    public CreateCardCommand(CardService cardService) {
        this.cardService = cardService;
    }

    @Override
    public void execute(Object... args) {
        String cardNumber = (String) args[0];
        int pinCode = (int) args[1];
        double balance = (double) args[2];

        cardService.createCard(cardNumber, pinCode, balance);
        System.out.println("Карта успешно создана.");
    }
}
