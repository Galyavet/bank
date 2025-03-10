package com.bank.commands.impl;

import com.bank.commands.Command;
import com.bank.dto.CardDTO;
import com.bank.service.CardService;
import com.bank.service.impl.ConsoleReader;

public class GetMoneyCommand implements Command {
    private final CardService cardService;

    public GetMoneyCommand(CardService cardService) {
        this.cardService = cardService;
    }

    @Override
    public void execute() {
        CardDTO dto = ConsoleReader.readValueFromCardId();
        cardService.getMoney(dto.getCardId(), dto.getBalance());
        System.out.println("Операция выполнена успешно.");
    }
}
