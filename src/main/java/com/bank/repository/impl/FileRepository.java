package com.bank.repository.impl;

import com.bank.model.Card;
import com.bank.repository.CardRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.bank.config.AppConfig.filepath;

public class FileRepository implements CardRepository {

    private final Map<Long, Card> cards;

    private final ObjectMapper objectMapper;

    public FileRepository() {
        cards = new HashMap<>();
        objectMapper = new ObjectMapper();
        loadCards();
    }

    @Override
    public void save(Card card) {
        cards.put(card.getId(), card);
        saveCards();
    }

    @Override
    public void deleteByCardNumber(String cardNumber) {
        Optional<Long> cardIdOptional = cards.entrySet().stream()
                .filter(entry -> entry.getValue().getCardNumber().equals(cardNumber))
                .map(Map.Entry::getKey)
                .findFirst();
        cards.remove(cardIdOptional.get());
        saveCards();
    }

    @Override
    public Map<Long, Card> getAllCards() {
        return new HashMap<>(cards);
    }

    @Override
    public Optional<Card> findByCardNumber(String cardNumber) {
        return cards.values().stream()
                .filter(card -> card.getCardNumber().equals(cardNumber))
                .findFirst();
    }

    private void saveCards() {
        try {
            File file = new File(filepath);

            File parentDir = file.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                parentDir.mkdirs();
            }

            objectMapper.writeValue(file, cards);
        } catch (IOException e) {
            System.out.println("Ошибка при записи файла: " + e.getMessage());
        }
    }

    private void loadCards() {
        File file = new File(filepath);
        if (!file.exists()) {
            System.out.println("Файл не найден. Создаем новое хранилище.");
            return;
        }

        try {
            cards.putAll(objectMapper.readValue(file, new TypeReference<Map<Long, Card>>() {
            }));
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}