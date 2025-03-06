package com.bank.service;

import com.bank.model.Card;

import java.util.Optional;

public interface CardService {
    void createCard(String cardNumber, int pinCode, double balance);
    Optional<Card> getCard(Long id);
    void deleteCard(Long id);
    void putMoney(Long cardId, double amount);
    void getMoney(Long cardId, double amount);
}
