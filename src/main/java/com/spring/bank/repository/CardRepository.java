package com.spring.bank.repository;

import com.spring.bank.model.Card;

public interface CardRepository {
    void saveCard(Card card);

    Card findCardByNumber(String cardNumber);
}
