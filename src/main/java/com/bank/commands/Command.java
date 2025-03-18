package com.bank.commands;

public interface Command {
    /**
     * Execution the operation in class commands
     */
    void execute();

    /**
     * Defines executing command
     * @return command
     */
    Operation getOperation();
}
