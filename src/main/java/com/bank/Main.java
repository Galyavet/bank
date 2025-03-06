package com.bank;

import com.bank.config.AppConfig;
import com.bank.controller.BankController;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        AppConfig.init();
        BankController bankController = AppConfig.getBankController();
        bankController.start();
    }

}