package model;

import model.commands.CheckBalanceCommand;
import model.commands.Command;
import model.commands.PutMoneyCommand;
import model.commands.WithdrawCommand;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Card card = new Card("1234123412341234", 123, 1000);
        ATM atm = new ATM();
        while (true){
            int decriment = 3;
            System.out.println("Введите пин-код: ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.equals(String.valueOf(card.getPin()))){
             break;
            }
            else if (decriment == 0){return;}
            else {
                decriment -= 1;
                System.out.println("Неверно! У вас осталось " + decriment + " попыток.");
            }
        }
        Command withdrawCommand = new WithdrawCommand(atm, card, 500);
        Command checkBalanceCommand = new CheckBalanceCommand(atm, card);
        Command putMoneyCommand = new PutMoneyCommand(atm, card, 1000);

        ATMInvoker atmInvoker = new ATMInvoker();

        atmInvoker.setCommand(withdrawCommand);
        atmInvoker.getCommand();

        atmInvoker.setCommand(checkBalanceCommand);
        atmInvoker.getCommand();

        atmInvoker.setCommand(putMoneyCommand);
        atmInvoker.getCommand();
    }
}


