package com.bank.commands;

public interface Command<T> {
    /**
     * Execution the operation in class commands
     */
    void execute(T dto);
}
