package com.bank.repository.impl;

import com.bank.model.Card;
import com.bank.repository.CardRepository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.bank.config.AppConfig.FILE_PATH;

public class FileRepository implements CardRepository {
    private final Map<Long, Card> cards = new HashMap<>();

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
        return cards.values().stream()
                .filter(card -> card.getId().equals(id))
                .findFirst();
    }

    @Override
    public void deleteById(Long id) {
        cards.remove(id);
        saveCards();
    }
    private void saveCards() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Card card : cards.values()) {
                writer.write(card.getId() + "," + card.getCardNumber() + "," + card.getPinCode() + "," + card.getBalance());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void loadCards() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Long id = Long.parseLong(parts[0]);
                String cardNumber = parts[1];
                int pinCode = Integer.parseInt(parts[2]);
                double balance = Double.parseDouble(parts[3]);
                cards.put(id, new Card(id, cardNumber, pinCode, balance));
            }
        } catch (IOException e) {
            System.out.println("Файл не найден или пуст.");
        }
    }
    @Override
    public Map<Long, Card> getAllCards() {
        return cards.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}