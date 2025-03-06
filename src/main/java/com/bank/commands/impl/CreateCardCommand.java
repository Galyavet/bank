package com.bank.commands.impl;

import com.bank.commands.Command;
import com.bank.dto.CreateCardDTO;
import com.bank.service.CardService;

public class CreateCardCommand implements Command<CreateCardDTO> {
    private final CardService cardService;

    public CreateCardCommand(CardService cardService) {
        this.cardService = cardService;
    }

    @Override
    public void execute(CreateCardDTO dto) {
        cardService.createCard(dto.getCardNumber(), dto.getPinCode(), dto.getBalance());
        System.out.println("Карта успешно создана.");
    }
}
