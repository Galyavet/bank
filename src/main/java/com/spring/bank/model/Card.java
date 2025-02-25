package com.spring.bank.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Card implements Serializable {
    private static final long serialVersionUID = 1L;

    private String number;
    private int pin;
    private double balance;

    public Card(String number, int pin, double balance) {
        this.pin = pin;
        this.balance = balance;
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getPin() {
        return pin;
    }

    public String getCardNumber() {
        return number;
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
