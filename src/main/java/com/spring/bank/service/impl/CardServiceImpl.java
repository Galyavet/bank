package com.spring.bank.service.impl;

import com.spring.bank.model.Card;
import com.spring.bank.repository.CardRepository;
import com.spring.bank.service.CardService;

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
        if (!repository.findById(id).isPresent()) {
            throw new IllegalArgumentException("Карта не найдена");
        }
        repository.deleteById(id);
    }

    @Override
    public void putMoney(Long cardId, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма для пополнения должна быть положительной");
        }

        Card card = repository.findById(cardId)
                .orElseThrow(() -> new IllegalArgumentException("Карта не найдена"));

        card.setBalance(card.getBalance() + amount);
        repository.save(card);
    }

    @Override
    public void getMoney(Long cardId, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма для снятия должна быть положительной");
        }

        Card card = repository.findById(cardId)
                .orElseThrow(() -> new IllegalArgumentException("Карта не найдена"));

        if (card.getBalance() < amount) {
            throw new IllegalArgumentException("Недостаточно средств на балансе");
        }

        card.setBalance(card.getBalance() - amount);
        repository.save(card);
    }
    private Long generateNewId() {
        return repository.getAllCards().keySet().stream()
                .max(Long::compareTo)
                .map(maxId -> maxId + 1)
                .orElse(1L);
    }
}
