package com.spring.bank.commands.impl;

import com.spring.bank.commands.Command;
import com.spring.bank.service.CardService;

public class InfoCommand implements Command {
    private final CardService cardService;

    public InfoCommand(CardService cardService) {
        this.cardService = cardService;
    }

    @Override
    public void execute(Object... args) {
        Long cardId = (Long) args[0];
        cardService.getCard(cardId).ifPresentOrElse(
                card -> System.out.println("Информация о карте: " + card),
                () -> System.out.println("Карта не найдена")
        );
    }
}
