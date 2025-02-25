package com.spring.bank.commands;

import com.spring.bank.commands.impl.Command;
import com.spring.bank.service.CardService;

public class CheckBalanceCommand implements Command {
    private final CardService cardService;
    private final String cardNumber;

    public CheckBalanceCommand(CardService cardService, String cardNumber) {
        this.cardService = cardService;
        this.cardNumber = cardNumber;
    }

    @Override
    public void execute() {
        cardService.checkBalance(cardNumber);
        if (cardService!= null) {
            System.out.println("Баланс: " + cardService.checkBalance(cardNumber));
        } else {
            System.out.println("Карта не найдена!");
        }
    }
}
