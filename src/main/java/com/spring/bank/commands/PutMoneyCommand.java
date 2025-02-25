package com.spring.bank.commands;

import com.spring.bank.commands.impl.Command;
import com.spring.bank.service.CardService;

public class PutMoneyCommand implements Command {
    private final CardService cardService;
    private final String cardNumber;
    private final double amount;

    public PutMoneyCommand(CardService cardService, String cardNumber, double amount) {
        this.cardService = cardService;
        this.cardNumber = cardNumber;
        this.amount = amount;
    }

    @Override
    public void execute() {
        cardService.deposit(cardNumber, amount);
    }
}
