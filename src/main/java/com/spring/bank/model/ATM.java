package com.spring.bank.model;

public class ATM {
    private int balance = 1000;

    public ATM() {
    }

    public void checkBalance(Card card) {
        System.out.println("Ваш баланс: " + card.getBankAccount() + " рублей");
    }

    public void withdrawMoney(Card card, double amount) {
        if (amount <= card.getBankAccount() && balance >= amount) {
            balance -= amount;
            card.setBankAccount(-amount);
            System.out.println("Выдано " + card.getBankAccount() + " рублей. Денег в банкомате: " + balance);
        } else {
            System.out.println("Недостаточно средств!");
        }
    }

    public void putMoney(Card card, double amount) {
        if (amount < 0 || amount > 1_000_000) {
            System.out.println("Недопустимая сумма!!!");
        } else {
            card.setBankAccount(amount);
            System.out.println("Баланс: " + card.getBankAccount());
        }
    }
}
