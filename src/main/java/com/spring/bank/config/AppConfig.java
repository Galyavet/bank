package com.spring.bank.config;

import com.spring.bank.commands.CommandExecutor;
import com.spring.bank.controller.BankController;
import com.spring.bank.model.ConsoleReader;
import com.spring.bank.repository.CardRepository;
import com.spring.bank.repository.impl.FileRepository;
import com.spring.bank.service.CardService;
import com.spring.bank.service.impl.CardServiceImpl;
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
