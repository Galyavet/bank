package com.bank;

import com.bank.config.AppConfig;
import com.bank.controller.ConsoleController;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        AppConfig.init();
        ConsoleController consoleController = AppConfig.getConsoleController();
        consoleController.start();
    }

}