package com.bank.commands.impl;

import com.bank.commands.Command;
import com.bank.dto.CardDTO;
import com.bank.service.CardService;
import com.bank.service.impl.ConsoleReader;

public class CreateCardCommand implements Command {

    private final CardService cardService;

    public CreateCardCommand(CardService cardService) {
        this.cardService = cardService;
    }

    @Override
    public void execute() {

        CardDTO cardDTO = ConsoleReader.readValueFromCreateNewCard();
        cardService.createCard(cardDTO.getCardNumber(), cardDTO.getPinCode(), cardDTO.getBalance());
        System.out.println("Карта успешно создана.");
    }
}
