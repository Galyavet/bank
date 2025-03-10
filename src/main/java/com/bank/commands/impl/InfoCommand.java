package com.bank.commands.impl;

import com.bank.commands.Command;
import com.bank.dto.CardDTO;
import com.bank.service.CardService;
import com.bank.service.impl.ConsoleReader;

public class InfoCommand implements Command{
    private final CardService cardService;

    public InfoCommand(CardService cardService) {
        this.cardService = cardService;
    }

    @Override
    public void execute() {
        CardDTO dto = ConsoleReader.readValueFromCardId();
        cardService.getCard(dto.getCardId()).ifPresentOrElse(
                card -> System.out.println("Информация о карте: " + card),
                () -> System.out.println("Карта не найдена")
        );
    }
}
