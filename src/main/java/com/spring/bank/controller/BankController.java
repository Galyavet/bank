package com.spring.bank.controller;

import com.spring.bank.commands.CommandExecutor;
import com.spring.bank.commands.Operation;
import com.spring.bank.model.ConsoleReader;

public class BankController {
    private final ConsoleReader consoleReader;
    private final CommandExecutor commandExecutor;

    public BankController(ConsoleReader consoleReader, CommandExecutor commandExecutor) {
        this.consoleReader = consoleReader;
        this.commandExecutor = commandExecutor;
    }

    public void start() {
        Operation operation;
        do {
            operation = consoleReader.getOperation();

            switch (operation) {
                case INFO:
                    Long cardIdInfo = consoleReader.readCardId();
                    commandExecutor.executeOperation(operation, cardIdInfo);
                    break;
                case GET_MONEY:
                    Long cardIdWithdraw = consoleReader.readCardId();
                    double amountWithdraw = consoleReader.readAmount();
                    commandExecutor.executeOperation(operation, cardIdWithdraw, amountWithdraw);
                    break;
                case PUT_MONEY:
                    Long cardIdDeposit = consoleReader.readCardId();
                    double amountDeposit = consoleReader.readAmount();
                    commandExecutor.executeOperation(operation, cardIdDeposit, amountDeposit);
                    break;
                case CREATE_CARD:
                    String cardNumber = consoleReader.readCardNumber();
                    int pinCode = consoleReader.readPinCode();
                    double balance = consoleReader.readAmount();
                    commandExecutor.executeOperation(operation, cardNumber, pinCode, balance);
                    break;
                case DELETE_CARD:
                    Long cardIdDelete = consoleReader.readCardId();
                    commandExecutor.executeOperation(operation, cardIdDelete);
                    break;
                case EXIT:
                    commandExecutor.executeOperation(operation);
                    break;
                default:
                    System.out.println("Неизвестная операция.");
            }
        } while (operation != Operation.EXIT);
    }
}
