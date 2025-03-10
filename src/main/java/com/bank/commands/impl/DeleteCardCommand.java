package com.bank.commands.impl;

import com.bank.commands.Command;
import com.bank.dto.CardDTO;
import com.bank.service.CardService;
import com.bank.service.impl.ConsoleReader;

public class DeleteCardCommand implements Command {
    private final CardService cardService;

    public DeleteCardCommand(CardService cardService) {
        this.cardService = cardService;
    }

    @Override
    public void execute() {
        CardDTO cardDTO = ConsoleReader.readValueFromCardId();
        cardService.deleteCard(cardDTO.getCardId());
        System.out.println("Карта успешно удалена.");
    }
}
