package com.bank.controller;

import com.bank.commands.CommandExecutor;
import com.bank.commands.Operation;
import com.bank.dto.CreateCardDTO;
import com.bank.dto.DeleteCardDTO;
import com.bank.dto.GetMoneyDTO;
import com.bank.dto.InfoCardDTO;
import com.bank.dto.PutMoneyDTO;
import com.bank.model.ConsoleReader;

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
                    commandExecutor.executeOperation(operation, new InfoCardDTO(cardIdInfo));
                    break;
                case GET_MONEY:
                    Long cardIdWithdraw = consoleReader.readCardId();
                    double amountWithdraw = consoleReader.readAmount();
                    commandExecutor.executeOperation(operation, new GetMoneyDTO(cardIdWithdraw, amountWithdraw));
                    break;
                case PUT_MONEY:
                    Long cardIdDeposit = consoleReader.readCardId();
                    double amountDeposit = consoleReader.readAmount();
                    commandExecutor.executeOperation(operation, new PutMoneyDTO(cardIdDeposit, amountDeposit));
                    break;
                case CREATE_CARD:
                    String cardNumber = consoleReader.readCardNumber();
                    int pinCode = consoleReader.readPinCode();
                    double balance = consoleReader.readAmount();
                    commandExecutor.executeOperation(operation, new CreateCardDTO(cardNumber, pinCode, balance));
                    break;
                case DELETE_CARD:
                    Long cardIdDelete = consoleReader.readCardId();
                    commandExecutor.executeOperation(operation, new DeleteCardDTO(cardIdDelete));
                    break;
                case EXIT:
                    commandExecutor.executeOperation(operation, null);
                    break;
                default:
                    System.out.println("Неизвестная операция.");
            }
        } while (operation != Operation.EXIT);
    }
}
