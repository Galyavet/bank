package com.bank.repository;

import com.bank.model.Card;

import java.util.Map;
import java.util.Optional;

public interface CardRepository {
    /**
     * Saves object card in file
     * @param card
     */
    void save(Card card);

    /**
     * Deletes card with same id in file
     * @param cardNumber
     */
    void deleteByCardNumber(String cardNumber);

    /**
     * Return all cards in buffer hashmap
     * @return
     */
    Map<Long, Card> getAllCards();

    /**
     * Finds card by a number
     * @param cardNumber - card number for searching
     * @return card in file
     */
    Optional<Card> findByCardNumber(String cardNumber);

}
