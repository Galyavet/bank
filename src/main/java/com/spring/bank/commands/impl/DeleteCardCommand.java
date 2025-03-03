package com.spring.bank.commands.impl;

import com.spring.bank.commands.Command;
import com.spring.bank.service.CardService;

public class DeleteCardCommand implements Command {
    private final CardService cardService;

    public DeleteCardCommand(CardService cardService) {
        this.cardService = cardService;
    }

    @Override
    public void execute(Object... args) {
        Long cardId = (Long) args[0];
        cardService.deleteCard(cardId);
        System.out.println("Карта успешно удалена.");
    }
}
