package com.spring.bank;

import com.spring.bank.commands.CheckBalanceCommand;
import com.spring.bank.commands.PutMoneyCommand;
import com.spring.bank.commands.WithdrawCommand;
import com.spring.bank.commands.impl.Command;
import com.spring.bank.model.ATM;
import com.spring.bank.model.ATMInvoker;
import com.spring.bank.model.Card;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите номер карты: ");
        String cardNumber = scanner.nextLine();

        System.out.println("Введите пин-код: ");
        int pin = Integer.parseInt(scanner.nextLine());

        System.out.println("Введите начальный баланс: ");
        double balance = Double.parseDouble(scanner.nextLine());

        Card card = new Card(cardNumber, pin, balance);
        ATM atm = new ATM();

        int attempts = 3;
        while (attempts > 0) {
            System.out.println("Введите пин-код: ");
            String input = scanner.nextLine();
            if (input.equals(String.valueOf(card.getPin()))) {
                break;
            } else {
                attempts--;
                if (attempts == 0) {
                    System.out.println("Попытки закончились. Карта заблокирована.");
                    return;
                }
                System.out.println("Неверно! У вас осталось " + attempts + " попыток.");
            }
        }

        while (true) {
            System.out.println("Выберите операцию:");
            System.out.println("1. Снять деньги");
            System.out.println("2. Проверить баланс");
            System.out.println("3. Положить деньги");
            System.out.println("4. Выйти");

            int choice = Integer.parseInt(scanner.nextLine());

            ATMInvoker atmInvoker = new ATMInvoker();

            switch (choice) {
                case 1:
                    System.out.println("Введите сумму для снятия: ");
                    double withdrawAmount = Double.parseDouble(scanner.nextLine());
                    Command withdrawCommand = new WithdrawCommand(atm, card, withdrawAmount);
                    atmInvoker.setCommand(withdrawCommand);
                    atmInvoker.getCommand();
                    break;
                case 2:
                    Command checkBalanceCommand = new CheckBalanceCommand(atm, card);
                    atmInvoker.setCommand(checkBalanceCommand);
                    atmInvoker.getCommand();
                    break;
                case 3:
                    System.out.println("Введите сумму для пополнения: ");
                    double depositAmount = Double.parseDouble(scanner.nextLine());
                    Command putMoneyCommand = new PutMoneyCommand(atm, card, depositAmount);
                    atmInvoker.setCommand(putMoneyCommand);
                    atmInvoker.getCommand();
                    break;
                case 4:
                    System.out.println("Выход из системы.");
                    return;
                default:
                    System.out.println("Неверно, попробуйте снова.");
            }
        }
    }

}
