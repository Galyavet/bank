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
public class PutMoneyCommand implements Command {
    private final CardService cardService;
    private final CurrentCardService currentCardService;
    private final ConsoleReader consoleReader;

    public PutMoneyCommand(CardService cardService, CurrentCardService currentCardService, ConsoleReader consoleReader) {
        this.cardService = cardService;
        this.currentCardService = currentCardService;
        this.consoleReader = consoleReader;
    }

    @Override
    public void execute() {
        Card currentCard = currentCardService.getCurrentCard();
        if (currentCard == null) {
            System.out.println("Вставьте карту!\n");
        } else {
            CardDTO dto = new CardDTO();
            dto.setCardNumber(currentCard.getCardNumber());
            dto.setBalance(consoleReader.readBalance());
            cardService.putMoney(dto.getCardNumber(), dto.getBalance());
        }
    }

    @Override
    public Operation getOperation() {
        return Operation.PUT_MONEY;
    }
}

