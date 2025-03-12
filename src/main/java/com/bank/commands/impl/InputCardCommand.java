package com.bank.commands.impl;

import com.bank.commands.Command;
import com.bank.config.AppConfig;
import com.bank.service.CardService;
import com.bank.service.impl.ConsoleReader;

public class InputCardCommand implements Command {
    private CardService cardService;

    public InputCardCommand(CardService cardService) {
        this.cardService = cardService;
    }

    @Override
    public void execute() {
        if (AppConfig.currentCard != null) {
            System.out.println("Сначала надо изъять карту!\n");
        } else {
            String cardNumber = ConsoleReader.readCardNumber();
            cardService.getCard(cardNumber).ifPresentOrElse(
                    card -> AppConfig.currentCard = card,
                    () -> System.out.println("\nКарта не найдена!"));
            if (AppConfig.currentCard != null) {
                if(ConsoleReader.verifyPinCode()) {
                    System.out.println("\nВход выполнен\n");
                }
                else{
                    System.out.println("\nКарта заблокирована!\n");
                    System.exit(0);
                }
            }
        }
    }
}
