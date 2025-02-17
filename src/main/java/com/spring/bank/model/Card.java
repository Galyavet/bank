package com.spring.bank.model;

import java.util.ArrayList;
import java.util.List;

public class Card {
    private String number;
    private int pin;
    private double bankAccount = 0;

    public Card(String number, int pin, double bankAccount) {
        this.pin = pin;
        this.bankAccount = bankAccount;
        this.number = number;
    }

    public double getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(double bankAccount) {
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
