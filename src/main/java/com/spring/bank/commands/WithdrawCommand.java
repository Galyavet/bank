package com.spring.bank.commands;

import com.spring.bank.commands.impl.Command;
import com.spring.bank.model.ATM;
import com.spring.bank.model.Card;

public class WithdrawCommand implements Command {
    private ATM theATM;
    private Card card;
    private double amount;

    public WithdrawCommand(ATM theAtm, Card card, double amount) {
        this.theATM = theAtm;
        this.card = card;
        this.amount = amount;
    }
    @Override
    public void execute() {
        theATM.withdrawMoney(card, amount);
    }
}
