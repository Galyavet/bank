package com.bank.commands.impl;

import com.bank.commands.Command;
import com.bank.dto.ExitCommandDTO;

public class ExitCommand implements Command<ExitCommandDTO> {

    @Override
    public void execute(ExitCommandDTO dto) {
        System.out.println("Выход из системы.");
        System.exit(0);
    }
}
