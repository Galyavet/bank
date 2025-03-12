package com.bank.commands.impl;

import com.bank.commands.Command;
import com.bank.config.AppConfig;
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
        if (AppConfig.currentCard == null) {
            System.out.println("Вставьте карту!");
        }
        else {
            CardDTO dto = new CardDTO();
            dto.setCardNumber(AppConfig.currentCard.getCardNumber());
            dto.setBalance(ConsoleReader.readBalance());
            cardService.getMoney(dto.getCardNumber(), dto.getBalance());
        }
    }
}
