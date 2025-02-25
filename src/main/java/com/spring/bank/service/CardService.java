package com.spring.bank.service;

import com.spring.bank.model.Card;
import com.spring.bank.repository.CardRepository;

public class CardService {
    private final CardRepository repository;

    public CardService(CardRepository repository) {
        this.repository = repository;
    }

    public void saveCard(Card card) {
        repository.saveCard(card);
    }

    public void withdraw(String cardNumber, double amount) {
        Card card = repository.findCardByNumber(cardNumber);
        if (card != null && card.getBalance() >= amount) {
            card.setBalance(card.getBalance() - amount);
            repository.saveCard(card);
        } else {
            throw new RuntimeException("Недостаточно средств или карта не найдена");
        }
    }

    public void deposit(String cardNumber, double amount) {
        Card card = repository.findCardByNumber(cardNumber);
        if (card != null) {
            card.setBalance(card.getBalance() + amount);
            repository.saveCard(card);
        } else {
            throw new RuntimeException("Карта не найдена");
        }
    }

    public double checkBalance(String cardNumber) {
        Card card = repository.findCardByNumber(cardNumber);
        if (card != null) {
            return card.getBalance();
        } else {
            throw new RuntimeException("Карта не найдена");
        }
    }
}
