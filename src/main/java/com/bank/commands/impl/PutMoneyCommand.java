package com.bank.commands.impl;

import com.bank.commands.Command;
import com.bank.dto.PutMoneyDTO;
import com.bank.service.CardService;

public class PutMoneyCommand implements Command<PutMoneyDTO> {
    private final CardService cardService;

    public PutMoneyCommand(CardService cardService) {
        this.cardService = cardService;
    }

    @Override
    public void execute(PutMoneyDTO dto) {
        cardService.putMoney(dto.getCardId(), dto.getAmount());
        System.out.println("Операция выполнена успешно.");
    }
}
