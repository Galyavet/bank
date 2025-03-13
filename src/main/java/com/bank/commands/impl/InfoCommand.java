package com.bank.commands.impl;

import com.bank.commands.Command;
import com.bank.config.AppConfig;
import com.bank.dto.CardDTO;
import com.bank.service.CardService;

public class InfoCommand implements Command {

    private final CardService cardService;

    public InfoCommand(CardService cardService) {
        this.cardService = cardService;
    }

    @Override
    public void execute() {
        if (AppConfig.currentCard == null) {
            System.out.println("Вставьте карту!\n");
        } else {
            CardDTO dto = new CardDTO();
            dto.setCardNumber(AppConfig.currentCard.getCardNumber());
            cardService.getCard(dto.getCardNumber()).ifPresentOrElse(
                    card -> System.out.println("Информация о карте: " + card),
                    () -> System.out.println("Карта не найдена"));

        }
    }
}
