package com.bank.commands.impl;

import com.bank.commands.Command;

public class ExitCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Выход из системы.");
        System.exit(0);
    }
}
