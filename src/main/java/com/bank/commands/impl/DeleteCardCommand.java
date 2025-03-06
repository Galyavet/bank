package com.bank.commands.impl;

import com.bank.commands.Command;
import com.bank.dto.DeleteCardDTO;
import com.bank.service.CardService;

public class DeleteCardCommand implements Command<DeleteCardDTO> {
    private final CardService cardService;

    public DeleteCardCommand(CardService cardService) {
        this.cardService = cardService;
    }

    @Override
    public void execute(DeleteCardDTO dto) {
        cardService.deleteCard(dto.getCardId());
        System.out.println("Карта успешно удалена.");
    }
}
