package com.bank.commands.impl;

import com.bank.commands.Command;
import com.bank.config.AppConfig;
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

        CardDTO cardDTO = ConsoleReader.readValueFromCardNumber();
        if (AppConfig.currentCard != null && (AppConfig.currentCard.getCardNumber().equals(cardDTO.getCardNumber()))) {
            System.out.println("Вы не можете удалить текущую карту потому что она находится в банкомате!");
        }
        else {
            cardService.deleteCard(cardDTO.getCardNumber());
        }

    }
}
