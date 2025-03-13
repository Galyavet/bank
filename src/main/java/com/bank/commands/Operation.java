package com.bank.commands;

import lombok.Getter;

@Getter
public enum Operation {
    INFO("Баланс карты"),
    GET_MONEY("Снять деньги"),
    PUT_MONEY("Пополнить баланс"),
    CREATE_CARD("Создать карту"),
    DELETE_CARD("Удалить карту"),
    INPUT_CARD("Вставить карту"),
    EJECT_CARD("Изъять карту"),
    EXIT("Выйти из системы");


    private final String description;

    Operation(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
