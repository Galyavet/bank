package com.bank.commands.impl;

import com.bank.commands.Command;
import com.bank.commands.Operation;
import com.bank.dto.CardDTO;
import com.bank.model.Card;
import com.bank.service.CardService;
import com.bank.service.impl.ConsoleReader;
import com.bank.service.impl.CurrentCardService;
import org.springframework.stereotype.Component;

@Component
public class DeleteCardCommand implements Command {
    private final CardService cardService;
    private final CurrentCardService currentCardService;
    private final ConsoleReader consoleReader;

    public DeleteCardCommand(CardService cardService, CurrentCardService currentCardService, ConsoleReader consoleReader) {
        this.cardService = cardService;
        this.currentCardService = currentCardService;
        this.consoleReader = consoleReader;
    }

    @Override
    public void execute() {
        CardDTO cardDTO = consoleReader.readValueFromCardNumber();
        Card currentCard = currentCardService.getCurrentCard();
        if (currentCard != null && currentCard.getCardNumber().equals(cardDTO.getCardNumber())) {
            System.out.println("Вы не можете удалить текущую карту, потому что она находится в банкомате!");
        } else {
            cardService.deleteCard(cardDTO.getCardNumber());
        }
    }

    @Override
    public Operation getOperation() {
        return Operation.DELETE_CARD;
    }
}
