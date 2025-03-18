package com.bank.commands.impl;

import com.bank.commands.Command;
import com.bank.commands.Operation;
import com.bank.dto.CardDTO;
import com.bank.service.CardService;
import com.bank.service.impl.ConsoleReader;
import org.springframework.stereotype.Component;

@Component
public class CreateCardCommand implements Command {

    private final CardService cardService;
    private final ConsoleReader consoleReader;


    public CreateCardCommand(CardService cardService, ConsoleReader consoleReader) {
        this.cardService = cardService;
        this.consoleReader = consoleReader;
    }

    @Override
    public void execute() {

        CardDTO cardDTO = consoleReader.readValueFromCreateNewCard();
        cardService.createCard(cardDTO.getCardNumber(), cardDTO.getPinCode(), cardDTO.getBalance());
        System.out.println("Карта успешно создана.");
    }

    @Override
    public Operation getOperation() {
        return Operation.CREATE_CARD;
    }
}
