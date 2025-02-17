package com.spring.bank.commands;

import com.spring.bank.commands.impl.Command;
import com.spring.bank.model.ATM;
import com.spring.bank.model.Card;

public class CheckBalanceCommand implements Command {
    private ATM theATM;
    private Card card;

    public CheckBalanceCommand(ATM theATM, Card card) {
        this.theATM = theATM;
        this.card = card;
    }

    @Override
    public void execute() {
        theATM.checkBalance(card);
    }
}
