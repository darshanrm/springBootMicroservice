package com.bankapplication.cards.controller;

import com.bankapplication.cards.model.Cards;
import com.bankapplication.cards.model.Customer;
import com.bankapplication.cards.repository.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardsController {
    @Autowired
    private CardsRepository cardsRepository;

    @GetMapping("/cards")
    public List<Cards> getCardDetails(@RequestBody Customer customer){
        List<Cards> cards = cardsRepository.findByCustomerId(customer.getCustomerId());
        if(cards!=null){
            return cards;
        }else{
            return null;
        }
    }
}
