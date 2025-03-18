package com.bank.config;

import com.bank.commands.Command;
import com.bank.controller.ConsoleController;
import com.bank.repository.CardRepository;
import com.bank.repository.impl.FileRepository;
import com.bank.service.CardService;
import com.bank.service.impl.CardServiceImpl;
import com.bank.service.impl.CommandExecutor;
import com.bank.service.impl.ConsoleReader;
import com.bank.service.impl.CurrentCardService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppConfig {

    @Value("${file.path}")
    private String filePath;

    @Bean
    public CurrentCardService currentCardService() {
        return new CurrentCardService();
    }

    @Bean
    public CardRepository cardRepository() {
        return new FileRepository(filePath);
    }

    @Bean
    public CardService cardService(CardRepository cardRepository) {
        return new CardServiceImpl(cardRepository);
    }

    @Bean
    public CommandExecutor commandExecutor(List<Command> commands) {
        return new CommandExecutor(commands);
    }

    @Bean
    public ConsoleReader consoleReader() {
        return new ConsoleReader(currentCardService());
    }

    @Bean
    public ConsoleController consoleController(ConsoleReader consoleReader, CommandExecutor commandExecutor) {
        return new ConsoleController(consoleReader, commandExecutor);
    }
}
