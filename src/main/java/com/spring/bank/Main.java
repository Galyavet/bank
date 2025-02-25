package com.spring.bank;

import com.spring.bank.repository.FileStorage;
import com.spring.bank.repository.H2Storage;
import com.spring.bank.service.CardService;
import com.spring.bank.view.ATMView;

public class Main {
    public static void main(String[] args) {
        FileStorage fileStorage = new FileStorage();
        
        CardService cardService = new CardService(fileStorage);

        ATMView atmView = new ATMView(cardService);
        atmView.start();
    }
}