package com.bank.service.impl;

import com.bank.model.Card;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Service
public class CurrentCardService {

    private Card currentCard;

    public void clearCurrentCard() {
        currentCard = null;
    }
}
