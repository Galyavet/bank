package com.bank.config;

import com.bank.model.Card;
import com.bank.service.impl.CommandExecutor;
import com.bank.controller.ConsoleController;
import com.bank.service.impl.ConsoleReader;
import com.bank.repository.CardRepository;
import com.bank.repository.impl.FileRepository;
import com.bank.service.CardService;
import com.bank.service.impl.CardServiceImpl;

import java.io.IOException;
import java.util.Properties;

public class AppConfig {

    public static Card currentCard = null;

    public static String filepath;

    private static CardRepository cardRepository;

    private static CardService cardService;

    private static CommandExecutor commandExecutor;

    private static ConsoleController consoleController;

    private static ConsoleReader consoleReader;


    public static void init() throws IOException {

        Properties prop = new Properties();
        prop.load(ClassLoader.getSystemResourceAsStream("application.properties"));
        filepath = prop.getProperty("file.path");

        cardRepository = new FileRepository();

        cardService = new CardServiceImpl(cardRepository);

        commandExecutor = new CommandExecutor(cardService);

        consoleReader = new ConsoleReader();

        consoleController = new ConsoleController(consoleReader, commandExecutor);
    }

    public static ConsoleController getConsoleController() {
        return consoleController;
    }
}
