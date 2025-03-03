package com.spring.bank.repository;

import com.spring.bank.model.Card;

import java.util.Map;
import java.util.Optional;

public interface CardRepository {
    /**
     * Saves object card in file
     * @param card
     */
    void save(Card card);

    /**
     * Finds card  with same id in file
     * @param id
     * @return
     */
    Optional<Card> findById(Long id);

    /**
     * Deletes card with same id in file
     * @param id
     */
    void deleteById(Long id);

    /**
     * Return all cards in buffer hashmap
     * @return
     */
    Map<Long, Card> getAllCards();
}
