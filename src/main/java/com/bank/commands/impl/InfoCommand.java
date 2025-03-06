package com.bank.commands.impl;

import com.bank.commands.Command;
import com.bank.dto.InfoCardDTO;
import com.bank.service.CardService;

public class InfoCommand implements Command<InfoCardDTO> {
    private final CardService cardService;

    public InfoCommand(CardService cardService) {
        this.cardService = cardService;
    }

    @Override
    public void execute(InfoCardDTO dto) {
        cardService.getCard(dto.getCardId()).ifPresentOrElse(
                card -> System.out.println("Информация о карте: " + card),
                () -> System.out.println("Карта не найдена")
        );
    }
}
