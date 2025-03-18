package com.bank.commands.impl;

import com.bank.commands.Command;
import com.bank.commands.Operation;
import com.bank.service.CardService;
import com.bank.service.impl.ConsoleReader;
import com.bank.service.impl.CurrentCardService;
import org.springframework.stereotype.Component;

@Component
public class InputCardCommand implements Command {
    private final CardService cardService;
    private final CurrentCardService currentCardService;
    private final ConsoleReader consoleReader;

    public InputCardCommand(CardService cardService, CurrentCardService currentCardService, ConsoleReader consoleReader) {
        this.cardService = cardService;
        this.currentCardService = currentCardService;
        this.consoleReader = consoleReader;
    }

    @Override
    public void execute() {
        if (currentCardService.getCurrentCard() != null) {
            System.out.println("Сначала надо изъять карту!\n");
        } else {
            String cardNumber = consoleReader.readCardNumber();
            cardService.getCard(cardNumber).ifPresentOrElse(
                    card -> {
                        currentCardService.setCurrentCard(card);
                        if (consoleReader.verifyPinCode()) {
                            System.out.println("\nВход выполнен\n");
                        } else {
                            System.out.println("\nКарта заблокирована!\n");
                            System.exit(0);
                        }
                    },
                    () -> System.out.println("\nКарта не найдена!"));
        }
    }

    @Override
    public Operation getOperation() {
        return Operation.INPUT_CARD;
    }
}
