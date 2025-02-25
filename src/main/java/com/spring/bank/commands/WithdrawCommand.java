package com.spring.bank.commands;

import com.spring.bank.commands.impl.Command;
import com.spring.bank.service.CardService;

public class WithdrawCommand implements Command {
    private final CardService cardService;
    private final String cardNumber;
    private final double amount;

    public WithdrawCommand(CardService cardService, String cardNumber, double amount) {
        this.cardService = cardService;
        this.cardNumber = cardNumber;
        this.amount = amount;
    }

    @Override
    public void execute() {
        cardService.withdraw(cardNumber, amount);
    }
}
