package com.bank.commands.impl;

import com.bank.commands.Command;
import com.bank.commands.Operation;
import com.bank.service.impl.CurrentCardService;
import org.springframework.stereotype.Component;

@Component
public class EjectCardCommand implements Command {
    private final CurrentCardService currentCardService;

    public EjectCardCommand(CurrentCardService currentCardService) {
        this.currentCardService = currentCardService;
    }

    @Override
    public void execute() {
        if (currentCardService.getCurrentCard() == null) {
            System.out.println("В банкомате нет карты!");
        } else {
            currentCardService.clearCurrentCard();
            System.out.println("Карта изъята!");
        }
    }

    @Override
    public Operation getOperation() {
        return Operation.EJECT_CARD;
    }
}
