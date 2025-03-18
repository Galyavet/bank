package com.bank.service.impl;

import com.bank.commands.Command;
import com.bank.commands.Operation;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CommandExecutor {

    private final Map<Operation, Command> allCommands;

    public CommandExecutor(List<Command> commands) {
        this.allCommands = commands.stream()
                .collect(Collectors.toMap(
                        Command::getOperation,
                        command -> command
                ));
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
