package com.bank.repository;

import com.bank.model.Card;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

@Repository
public interface CardRepository {
    /**
     * Saves object card in file
     * @param card - saves in file
     */
    void save(Card card);

    /**
     * Deletes card with same id in file
     * @param cardNumber - deletes from file
     */
    void deleteByCardNumber(String cardNumber);

    /**
     * @return all cards in buffer hashmap
     */
    Map<Long, Card> getAllCards();

    /**
     * Finds card by a number
     * @param cardNumber - card number for searching
     * @return card in file
     */
    Optional<Card> findByCardNumber(String cardNumber);
}
