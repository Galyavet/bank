package com.spring.bank.model;

import com.spring.bank.commands.Operation;

import java.util.Scanner;

public class ConsoleReader {
    private final Scanner scanner;

    public ConsoleReader() {
        this.scanner = new Scanner(System.in);
    }

    public Operation getOperation() {
        System.out.println("Выберите операцию:");
        System.out.println("1. INFO");
        System.out.println("2. GET_MONEY");
        System.out.println("3. PUT_MONEY");
        System.out.println("4. CREATE_CARD");
        System.out.println("5. DELETE_CARD");
        System.out.println("6. EXIT");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                return Operation.INFO;
            case 2:
                return Operation.GET_MONEY;
            case 3:
                return Operation.PUT_MONEY;
            case 4:
                return Operation.CREATE_CARD;
            case 5:
                return Operation.DELETE_CARD;
            case 6:
                return Operation.EXIT;
            default:
                throw new IllegalArgumentException("Неверный выбор операции.");
        }
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
