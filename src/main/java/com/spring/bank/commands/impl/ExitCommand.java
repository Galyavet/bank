package com.spring.bank.commands.impl;

import com.spring.bank.commands.Command;

public class ExitCommand implements Command {

    @Override
    public void execute(Object...args) {
        System.out.println("Выход из системы.");
        System.exit(0);
    }
}
