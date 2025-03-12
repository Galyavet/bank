package com.bank.service;

import com.bank.model.Card;

import java.util.Optional;

public interface CardService {
    /**
     * Create card
     * @param cardNumber - card number
     * @param pinCode - card password
     * @param balance - card balance
     */
    void createCard(String cardNumber, int pinCode, double balance);

    /**
     * Get card from file by id
     * @param id - need to find same card
     * @return optional card
     */
    Optional<Card> getCard(String id);

    /**
     * Delete card by id
     * @param id - identity of the card
     */
    void deleteCard(String id);

    /**
     * Put money on the card
     * @param cardNumber - identity of the card
     * @param amount - how much money have to put on the card
     */
    void putMoney(String cardNumber, double amount);

    /**
     * Get money from the card
     * @param cardNumber - identity of the card
     * @param amount - how much monet have to get from the card
     */
    void getMoney(String cardNumber, double amount);

}
