package com.bankapplication.loans.controller;

import com.bankapplication.loans.config.LoansServiceConfig;
import com.bankapplication.loans.model.Customer;
import com.bankapplication.loans.model.Loans;
import com.bankapplication.loans.model.Properties;
import com.bankapplication.loans.repository.LoansRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoansController {
    @Autowired
    private LoansRepository loansRepository;

    @Autowired
    private LoansServiceConfig loansServiceConfig;

    @GetMapping("/loans")
    public List<Loans> getLoansDetails(@RequestBody Customer customer){
        List<Loans> loans = loansRepository.findByCustomerIdOrderByStartDateDesc(customer.getCustomerId());
        if(loans!=null){
            return loans;
        }else{
            return null;
        }
    }

    @GetMapping("/loan/properties")
    public String getPropertyDetails() throws JsonProcessingException{
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(loansServiceConfig.getMsg(),loansServiceConfig.getBuildVersion(),
                loansServiceConfig.getMailDetails(),loansServiceConfig.getActiveBranches());
        String str = ow.writeValueAsString(properties);
        return str;
    }
}
