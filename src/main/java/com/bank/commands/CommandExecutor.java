package com.bank.commands;

import com.bank.commands.impl.CreateCardCommand;
import com.bank.commands.impl.DeleteCardCommand;
import com.bank.commands.impl.ExitCommand;
import com.bank.commands.impl.GetMoneyCommand;
import com.bank.commands.impl.InfoCommand;
import com.bank.commands.impl.PutMoneyCommand;
import com.bank.service.CardService;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutor {
    private final Map<Operation, Command<?>> allCommands;

    public CommandExecutor(CardService cardService) {
        allCommands = new HashMap<>();
        allCommands.put(Operation.EXIT, new ExitCommand());
        allCommands.put(Operation.INFO, new InfoCommand(cardService));
        allCommands.put(Operation.GET_MONEY, new GetMoneyCommand(cardService));
        allCommands.put(Operation.PUT_MONEY, new PutMoneyCommand(cardService));
        allCommands.put(Operation.CREATE_CARD, new CreateCardCommand(cardService));
        allCommands.put(Operation.DELETE_CARD, new DeleteCardCommand(cardService));
    }

    public <T> void executeOperation(Operation operation, T dto) {
        Command<T> command = (Command<T>) allCommands.get(operation);
        if (command != null) {
            command.execute(dto);
        } else {
            throw new IllegalArgumentException("Неизвестная операция");
        }
    }
}
