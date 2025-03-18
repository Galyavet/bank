package com.bank.controller;

import com.bank.commands.Command;
import com.bank.commands.Operation;
import com.bank.service.impl.CommandExecutor;
import com.bank.service.impl.ConsoleReader;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.util.Arrays;

@AllArgsConstructor
@Controller
public class ConsoleController implements CommandLineRunner {

    private final ConsoleReader consoleReader;

    private final CommandExecutor commandExecutor;


    public void printMenu() {
        System.out.println("Выберите операцию:");
        Arrays.stream(Operation.values())
                .map(operation -> (operation.ordinal() + 1) + ". " + operation.getDescription())
                .forEach(System.out::println);
    }

    @Override
    public void run(String... args) throws Exception {
        start();
    }

    public void start() {
        while (true) {
            try {
                printMenu();
                int userInput = consoleReader.readInput() - 1;
                Command command = commandExecutor.getOperationByIndex(userInput);
                if (command != null) {
                    command.execute();
                } else {
                    System.out.println("Неверное значение. Попробуйте снова.");
                }
            } catch (NullPointerException e) {
                System.out.println("Ошибка: команда не найдена. Попробуйте снова.");
            } catch (Exception e) {
                System.out.println("Произошла ошибка: " + e.getMessage());
            }
        }
    }
}
