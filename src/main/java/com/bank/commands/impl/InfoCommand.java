package com.bank.commands.impl;

import com.bank.commands.Command;
import com.bank.commands.Operation;
import com.bank.dto.CardDTO;
import com.bank.model.Card;
import com.bank.service.CardService;
import com.bank.service.impl.CurrentCardService;
import org.springframework.stereotype.Component;

@Component
public class InfoCommand implements Command {
    private final CardService cardService;
    private final CurrentCardService currentCardService;

    public InfoCommand(CardService cardService, CurrentCardService currentCardService) {
        this.cardService = cardService;
        this.currentCardService = currentCardService;
    }

    @Override
    public void execute() {
        Card currentCard = currentCardService.getCurrentCard();
        if (currentCard == null) {
            System.out.println("Вставьте карту!\n");
        } else {
            CardDTO dto = new CardDTO();
            dto.setCardNumber(currentCard.getCardNumber());
            cardService.getCard(dto.getCardNumber()).ifPresentOrElse(
                    card -> System.out.println("Информация о карте: " + card),
                    () -> System.out.println("Карта не найдена"));
        }
    }

    @Override
    public Operation getOperation() {
        return Operation.INFO;
    }
}
