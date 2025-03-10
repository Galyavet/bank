package com.bank.commands;

import com.bank.service.CardService;

public interface Command<T> {
    /**
     * Execution the operation in class commands
     */
    void execute();
}
