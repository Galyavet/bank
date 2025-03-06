package com.bank.config;

import com.bank.commands.CommandExecutor;
import com.bank.controller.BankController;
import com.bank.model.ConsoleReader;
import com.bank.repository.CardRepository;
import com.bank.repository.impl.FileRepository;
import com.bank.service.CardService;
import com.bank.service.impl.CardServiceImpl;
import lombok.Getter;

import java.io.IOException;
import java.util.Properties;

public class AppConfig {
    public static String FILE_PATH;
    private static CardRepository cardRepository;
    private static CardService cardService;
    private static CommandExecutor commandExecutor;
    @Getter
    private static BankController bankController;
    private static ConsoleReader consoleReader;

    public static void init() throws IOException {
        Properties prop = new Properties();
        prop.load(ClassLoader.getSystemResourceAsStream("application.properties"));
        FILE_PATH = prop.getProperty("FILE_PATH");

        cardRepository = new FileRepository();
        cardService = new CardServiceImpl(cardRepository);
        commandExecutor = new CommandExecutor(cardService);
        consoleReader = new ConsoleReader();
        bankController = new BankController(consoleReader, commandExecutor);
    }
}
