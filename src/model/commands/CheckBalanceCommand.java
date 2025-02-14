package model.commands;

import model.ATM;
import model.Card;

public class CheckBalanceCommand implements Command {
    private ATM theATM;
    private Card card;

    public CheckBalanceCommand(ATM theATM, Card card) {
        this.theATM = theATM;
        this.card = card;
    }
    public void execute() {
        theATM.checkBalance(card);
    }
}
