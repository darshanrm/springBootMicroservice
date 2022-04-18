package com.bankapplication.loans.controller;

import com.bankapplication.loans.model.Customer;
import com.bankapplication.loans.model.Loans;
import com.bankapplication.loans.repository.LoansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoansController {
    @Autowired
    private LoansRepository loansRepository;

    @GetMapping("/loans")
    public List<Loans> getLoansDetails(@RequestBody Customer customer){
        List<Loans> loans = loansRepository.findByCustomerIdOrderByStartDateDesc(customer.getCustomerId());
        if(loans!=null){
            return loans;
        }else{
            return null;
        }
    }
}
