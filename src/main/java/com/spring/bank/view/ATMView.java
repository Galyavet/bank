package com.spring.bank.view;

import com.spring.bank.commands.CheckBalanceCommand;
import com.spring.bank.commands.PutMoneyCommand;
import com.spring.bank.commands.WithdrawCommand;
import com.spring.bank.model.ATMInvoker;
import com.spring.bank.model.Card;
import com.spring.bank.service.CardService;

import java.util.Scanner;

public class ATMView {
    private final CardService cardService;
    private final Scanner scanner;

    public ATMView(CardService cardService) {
        this.cardService = cardService;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Введите номер карты: ");
        String cardNumber = scanner.nextLine();

        System.out.println("Введите пин-код: ");
        int pin = Integer.parseInt(scanner.nextLine());

        System.out.println("Введите начальный баланс: ");
        double balance = Double.parseDouble(scanner.nextLine());

        cardService.saveCard(new Card(cardNumber, pin, balance));

        while (true) {
            System.out.println("Выберите операцию:");
            System.out.println("1. Снять деньги");
            System.out.println("2. Проверить баланс");
            System.out.println("3. Положить деньги");
            System.out.println("4. Выйти");

            int choice = Integer.parseInt(scanner.nextLine());

            ATMInvoker invoker = new ATMInvoker();

            switch (choice) {
                case 1:
                    System.out.println("Введите сумму для снятия: ");
                    double withdrawAmount = Double.parseDouble(scanner.nextLine());
                    invoker.setCommand(new WithdrawCommand(cardService, cardNumber, withdrawAmount));
                    invoker.executeCommand();
                    break;
                case 2:
                    invoker.setCommand(new CheckBalanceCommand(cardService, cardNumber));
                    invoker.executeCommand();
                    break;
                case 3:
                    System.out.println("Введите сумму для пополнения: ");
                    double depositAmount = Double.parseDouble(scanner.nextLine());
                    invoker.setCommand(new PutMoneyCommand(cardService, cardNumber, depositAmount));
                    invoker.executeCommand();
                    break;
                case 4:
                    System.out.println("Выход из системы.");
                    return;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }
}
