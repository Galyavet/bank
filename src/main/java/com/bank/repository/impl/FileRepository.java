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

    private final Map<Long, Card> cards = new HashMap<>();

    private final ObjectMapper objectMapper = new ObjectMapper();

    public FileRepository() {
        loadCards();
    }

    @Override
    public void save(Card card) {
        cards.put(card.getId(), card);
        saveCards();
    }

    @Override
    public Optional<Card> findById(Long id) {
        return Optional.ofNullable(cards.get(id));
    }

    @Override
    public void deleteById(Long id) {
        cards.remove(id);
        saveCards();
    }

    @Override
    public Map<Long, Card> getAllCards() {
        return new HashMap<>(cards);
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