package com.bank.controller;

import com.bank.commands.Operation;
import com.bank.config.AppConfig;
import com.bank.service.impl.CommandExecutor;
import com.bank.service.impl.ConsoleReader;
import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public class ConsoleController {

    private final ConsoleReader consoleReader;

    private final CommandExecutor commandExecutor;


    public void printMenu() {
        System.out.println("Выберите операцию:");
        Arrays.stream(Operation.values())
                .map(operation -> (operation.ordinal() + 1) + ". " + operation.getDescription())
                .forEach(System.out::println);
    }


    public void start() {
        while (true) {
            try {
                printMenu();
                commandExecutor.getOperationByIndex(consoleReader.readInput() - 1).execute();
            } catch (NullPointerException e) {
                System.out.println("Неверное значение");
            }
        }
    }
}
