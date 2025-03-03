package com.spring.bank;

import com.spring.bank.config.AppConfig;
import com.spring.bank.controller.BankController;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        AppConfig.init();
        BankController bankController = AppConfig.getBankController();
        bankController.start();
    }

}