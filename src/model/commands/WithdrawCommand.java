package model.commands;

import model.ATM;
import model.Card;

public class WithdrawCommand implements Command {
    private ATM theATM;
    private Card card;
    private int amount;

    public WithdrawCommand(ATM theAtm, Card card, int amount) {
        this.theATM = theAtm;
        this.card = card;
        this.amount = amount;
    }
    public void execute() {
        theATM.withdrawMoney(card, amount);
    }
}
