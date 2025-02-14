package model.commands;

import model.ATM;
import model.Card;

public class PutMoneyCommand implements Command {
    private ATM theATM;
    private Card card;
    private int amount;

    public PutMoneyCommand(ATM theATM, Card card, int amount) {
        this.theATM = theATM;
        this.card = card;
        this.amount = amount;
    }
    public void execute() {
        theATM.putMoney(card, amount);
    }
}
