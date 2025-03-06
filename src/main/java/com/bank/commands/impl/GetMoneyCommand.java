package com.bank.commands.impl;

import com.bank.commands.Command;
import com.bank.dto.GetMoneyDTO;
import com.bank.service.CardService;

public class GetMoneyCommand implements Command<GetMoneyDTO> {
    private final CardService cardService;

    public GetMoneyCommand(CardService cardService) {
        this.cardService = cardService;
    }

    @Override
    public void execute(GetMoneyDTO dto) {
        cardService.getMoney(dto.getCardId(), dto.getAmount());
        System.out.println("Операция выполнена успешно.");
    }
}
