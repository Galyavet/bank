package com.bank.service.impl;

import com.bank.commands.Operation;
import com.bank.config.AppConfig;
import com.bank.dto.CardDTO;

import java.util.Scanner;

public class ConsoleReader {
    private static final Scanner scanner = new Scanner(System.in);

    public ConsoleReader() {

    }

    public int readInput() {
        int commandIndex = 0;

        while (true) {
            try {
                System.out.print("\nВведите номер: ");
                commandIndex = Integer.parseInt(scanner.nextLine());
                System.out.println();

                if (commandIndex >= 1 && commandIndex <= Operation.values().length) {
                    return commandIndex;
                } else {
                    System.out.println("Введите число от 1 до " + Operation.values().length);
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат данных. Введите число.");
            }
        }
    }

    public static CardDTO readValueFromCreateNewCard() {
        return new CardDTO( readCardNumber(), readPinCode(), readBalance());
    }

    public static CardDTO readValueFromCardNumber() {
        CardDTO cardDto = new CardDTO();
        cardDto.setCardNumber(readCardNumber());
        return cardDto;
    }
    public static CardDTO readValueFromCardBalance(){
        CardDTO cardDto = readValueFromCardNumber();
        cardDto.setBalance(readBalance());
        return cardDto;
    }

    public static String readCardNumber() {
        while (true) {
            System.out.println("Введите номер карты: ");
            String cardNumber = scanner.nextLine();
            if (cardNumber.matches("\\d{5}")) {
                return cardNumber;
            } else {
                System.out.println("Номер карты должен состоять из 5 цифр.");
            }
        }

    }

    public static int readPinCode() {
        while (true) {
            try {
                System.out.println("Введите пин-код: ");
                String input = scanner.nextLine();
                int pinCode = Integer.parseInt(input);
                if (pinCode >= 1000 && pinCode <= 9999) {
                    return pinCode;
                } else {
                    System.out.println("Пин-код должен состоять из 4 цифр.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Введите корректное число для пин-кода.");
            }
        }
    }

    public static double readBalance() {
        while (true) {
            try {
                System.out.println("Введите баланс: ");
                String input = scanner.nextLine();
                double balance = Double.parseDouble(input);
                if (balance >= 0) {
                    return balance;
                } else {
                    System.out.println("Баланс не может быть отрицательным.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Введите корректное число для баланса.");
            }
        }
    }
    public static boolean verifyPinCode(){
        for (int i = 0; i < 3; i++) {
            try {
                System.out.println("Введите пин-код: ");
                String input = scanner.nextLine();
                if(Integer.parseInt(input) == AppConfig.currentCard.getPinCode()){
                    return true;
                }
                System.out.println("Осталось попыток: " + (2 - i));
            } catch (NumberFormatException e) {
                System.out.println("Введите корректное число для пин-кода.");
            }

        }
        return false;
    }
}
