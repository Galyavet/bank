package com.bank.commands.impl;

import com.bank.commands.Command;
import com.bank.commands.Operation;
import org.springframework.stereotype.Component;

@Component
public class ExitCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Выход из системы.");
        System.exit(0);
    }

    @Override
    public Operation getOperation() {
        return Operation.EXIT;
    }
}
