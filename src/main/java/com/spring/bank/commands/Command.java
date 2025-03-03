package com.spring.bank.commands;

public interface Command {
    /**
     * Execution the operation in class commands
     */
    void execute(Object...args);
}
