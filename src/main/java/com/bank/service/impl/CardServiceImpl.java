package com.bank.service.impl;

import com.bank.model.Card;
import com.bank.repository.CardRepository;
import com.bank.service.CardService;

import java.util.Optional;

public class CardServiceImpl implements CardService {

    private final CardRepository repository;

    public CardServiceImpl(CardRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createCard(String cardNumber, int pinCode, double balance) {
        Long newId = generateNewId();
        Card card = new Card(newId, cardNumber, pinCode, balance);
        repository.save(card);
    }

    @Override
    public Optional<Card> getCard(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteCard(Long id) {
        repository.deleteById(id);
        System.out.println("Карта успешно удалена.");
    }

    @Override
    public void putMoney(Long cardId, double amount) {
        Card card = repository.findById(cardId)
                .orElseThrow(() -> new IllegalArgumentException("Карта не найдена"));
        card.setBalance(card.getBalance() + amount);
        repository.save(card);
        System.out.println("Баланс успешно пополнен.");

    }

    @Override
    public void getMoney(Long cardId, double amount) {
        Card card = repository.findById(cardId)
                .orElseThrow(() -> new IllegalArgumentException("Карта не найдена"));
        card.setBalance(card.getBalance() - amount);
        repository.save(card);
        System.out.println("Средства успешно сняты.");
    }

    private Long generateNewId() {
        return repository.getAllCards().keySet().stream()
                .max(Long::compareTo)
                .map(maxId -> maxId + 1)
                .orElse(1L);
    }
}
