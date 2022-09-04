package com.bankapplication.cards.controller;

import com.bankapplication.cards.config.CardsServiceConfig;
import com.bankapplication.cards.model.Cards;
import com.bankapplication.cards.model.Customer;
import com.bankapplication.cards.model.Properties;
import com.bankapplication.cards.repository.CardsRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CardsController {

    private static final Logger logger = LoggerFactory.getLogger(CardsController.class);

    @Autowired
    private CardsRepository cardsRepository;

    @Autowired
    private CardsServiceConfig cardsServiceConfig;

    @PostMapping("/cards")
    public List<Cards> getCardDetails(@RequestHeader("bank-correlation-id") String correlationid, @RequestBody Customer customer){
        List<Cards> cards = cardsRepository.findByCustomerId(customer.getCustomerId());
        if(cards!=null){
            return cards;
        }else{
            return null;
        }
    }

    @GetMapping("/card/properties")
    public String getPropertyDetails() throws JsonProcessingException{
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(cardsServiceConfig.getMsg(), cardsServiceConfig.getBuildVersion(),
                cardsServiceConfig.getMailDetails(),cardsServiceConfig.getActiveBranches());
        String str = ow.writeValueAsString(properties);
        return str;
    }
}
