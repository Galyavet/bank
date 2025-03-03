package com.spring.bank.commands;

import com.spring.bank.commands.impl.CreateCardCommand;
import com.spring.bank.commands.impl.DeleteCardCommand;
import com.spring.bank.commands.impl.ExitCommand;
import com.spring.bank.commands.impl.GetMoneyCommand;
import com.spring.bank.commands.impl.InfoCommand;
import com.spring.bank.commands.impl.PutMoneyCommand;
import com.spring.bank.service.CardService;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutor {
    private final Map<Operation, Command> allCommands;

    public CommandExecutor(CardService cardService) {
        allCommands = new HashMap<>();
        allCommands.put(Operation.EXIT, new ExitCommand());
        allCommands.put(Operation.INFO, new InfoCommand(cardService));
        allCommands.put(Operation.GET_MONEY, new GetMoneyCommand(cardService));
        allCommands.put(Operation.PUT_MONEY, new PutMoneyCommand(cardService));
        allCommands.put(Operation.CREATE_CARD, new CreateCardCommand(cardService));
        allCommands.put(Operation.DELETE_CARD, new DeleteCardCommand(cardService));
    }

    public void executeOperation(Operation operation, Object... args) {
        Command command = allCommands.get(operation);
        if (command != null) {
            command.execute(args);
        } else {
            throw new IllegalArgumentException("Неизвестная операция");
        }
    }
}
