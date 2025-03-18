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
    public Optional<Card> getCard(String cardNumber) {
        return repository.findByCardNumber(cardNumber);
    }

    @Override
    public void deleteCard(String cardNumber) {
        Optional<Card> cardOptional = repository.findByCardNumber(cardNumber);
        if (cardOptional.isPresent()) {
            repository.deleteByCardNumber(cardNumber);
            System.out.println("Карта успешно удалена.");
        } else {
            System.out.println("Ошибка: Карта с номером " + cardNumber + " не найдена.");
        }
    }

    @Override
    public void putMoney(String cardNumber, double amount) {
        Optional<Card> cardOptional = repository.findByCardNumber(cardNumber);
        if (cardOptional.isPresent()) {
            Card card = cardOptional.get();
            card.setBalance(card.getBalance() + amount);
            repository.save(card);
            System.out.println("Баланс успешно пополнен.");
        } else {
            System.out.println("Карта с номером " + cardNumber + " не найдена.");
        }

    }

    @Override
    public void getMoney(String cardNumber, double amount) {
        Optional<Card> cardOptional = repository.findByCardNumber(cardNumber);
        if (cardOptional.isPresent()) {
            Card card = cardOptional.get();
            if (card.getBalance() >= amount) {
                card.setBalance(card.getBalance() - amount);
                repository.save(card);
                System.out.println("Средства успешно сняты.");
            } else {
                System.out.println("Ошибка: Недостаточно средств на карте.");
            }
        } else {
            System.out.println("Ошибка: Карта с номером " + cardNumber + " не найдена.");
        }
    }


    private Long generateNewId() {
        return repository.getAllCards().keySet().stream()
                .max(Long::compareTo)
                .map(maxId -> maxId + 1)
                .orElse(1L);
    }
}
