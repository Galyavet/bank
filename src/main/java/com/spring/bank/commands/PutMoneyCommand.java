package com.spring.bank.commands;

import com.spring.bank.commands.impl.Command;
import com.spring.bank.model.ATM;
import com.spring.bank.model.Card;

public class PutMoneyCommand implements Command {
    private ATM atm;
    private Card card;
    private double amount;

    public PutMoneyCommand(ATM atm, Card card, double amount) {
        this.atm = atm;
        this.card = card;
        this.amount = amount;
    }
    @Override
    public void execute() {
        atm.putMoney(card, amount);
    }
}
