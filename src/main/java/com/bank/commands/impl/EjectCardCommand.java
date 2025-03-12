package com.bank.commands.impl;

import com.bank.commands.Command;
import com.bank.config.AppConfig;

public class EjectCardCommand implements Command {

    @Override
    public void execute() {
        if(AppConfig.currentCard == null) {
            System.out.println("В банкомате нет карты!");
        }
        else{
            AppConfig.currentCard = null;
            System.out.println("Карта изъята!");
        }
    }
}
