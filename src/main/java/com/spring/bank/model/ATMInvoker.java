package com.spring.bank.model;

import com.spring.bank.commands.impl.Command;

public class ATMInvoker {
    private Command command;

    public void getCommand() {
        command.execute();
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}