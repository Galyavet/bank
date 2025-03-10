package com.bank.service.impl;

import com.bank.commands.Command;
import com.bank.commands.Operation;
import com.bank.commands.impl.CreateCardCommand;
import com.bank.commands.impl.DeleteCardCommand;
import com.bank.commands.impl.ExitCommand;
import com.bank.commands.impl.GetMoneyCommand;
import com.bank.commands.impl.InfoCommand;
import com.bank.commands.impl.PutMoneyCommand;
import com.bank.service.CardService;

import java.util.LinkedHashMap;
import java.util.Map;

public class CommandExecutor {

    private final Map<Operation, Command> allCommands;

    public CommandExecutor(CardService cardService) {

        allCommands = new LinkedHashMap<>();
        allCommands.put(Operation.INFO, new InfoCommand(cardService));
        allCommands.put(Operation.GET_MONEY, new GetMoneyCommand(cardService));
        allCommands.put(Operation.PUT_MONEY, new PutMoneyCommand(cardService));
        allCommands.put(Operation.CREATE_CARD, new CreateCardCommand(cardService));
        allCommands.put(Operation.DELETE_CARD, new DeleteCardCommand(cardService));
        allCommands.put(Operation.EXIT, new ExitCommand());
    }

    public Command getOperationByIndex(int index) {
        try {
            return allCommands.get(Operation.values()[index]);
        } catch (Exception e) {
            System.out.println("Нет такой команды");
        }
        return null;
    }
}
