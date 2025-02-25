package com.spring.bank.repository;

import com.spring.bank.model.Card;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class FileStorage implements CardRepository {
    private static final String FILE_PATH = "cards.dat";

    @Override
    public void saveCard(Card card) {
        Map<String, Card> cards = loadCards();
        cards.put(card.getCardNumber(), card);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH, false))) {
            oos.writeObject(cards);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }   
    @Override
    public Card findCardByNumber(String cardNumber) {
        Map<String, Card> cards = loadCards();
        return cards.get(cardNumber);
    }

    private Map<String, Card> loadCards() {
        File file = new File(FILE_PATH);
        if (!file.exists()|| file.length() == 0) {
            return new HashMap<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (Map<String, Card>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new HashMap<>();
    }
}