package model;

import model.commands.Command;

public class ATMInvoker {
    private Command command;

    public void getCommand() {
        command.execute();
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}
