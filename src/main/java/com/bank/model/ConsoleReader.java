package com.bank.model;

import com.bank.commands.Operation;

import java.util.Scanner;

public class ConsoleReader {
    private final Scanner scanner;

    public ConsoleReader() {
        this.scanner = new Scanner(System.in);
    }

    public Operation getOperation() {
        System.out.println("Выберите операцию:");
        for (Operation operation : Operation.values()) {
            System.out.println((operation.ordinal() + 1) + ". " + operation.getDescription());
        }

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice < 1 || choice > Operation.values().length) {
            throw new IllegalArgumentException("Неверный выбор операции.");
        }

        return Operation.values()[choice - 1];
    }

    public Long readCardId() {
        System.out.println("Введите ID карты:");
        return scanner.nextLong();
    }

    public double readAmount() {
        System.out.println("Введите сумму:");
        return scanner.nextDouble();
    }

    public String readCardNumber() {
        System.out.println("Введите номер карты:");
        return scanner.nextLine();
    }

    public int readPinCode() {
        System.out.println("Введите пин-код:");
        return scanner.nextInt();
    }
}
