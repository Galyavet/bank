package model;

import java.util.ArrayList;
import java.util.List;

public class Card {
    private String number;
    private int pin;
    private int bankAccount = 0;

    public Card() {
        this.pin = 0;
        this.number = "0000000000000000";
        this.bankAccount = 0;
    }

    public Card(String number, int pin, int bankAccount) {
        this.pin = pin;
        this.bankAccount = bankAccount;
        this.number = number;
    }

    public int getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(int bankAccount) {
        this.bankAccount += bankAccount;
    }

    public int getPin() {
        return pin;
    }

    @Override
    public String toString() {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 16; i+=4) {
            list.add(number.substring(i, i + 4));
        }
        return String.join("-", list);
    }
}
