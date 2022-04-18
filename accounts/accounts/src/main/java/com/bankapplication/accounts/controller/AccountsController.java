package com.bankapplication.accounts.controller;

import com.bankapplication.accounts.model.Accounts;
import com.bankapplication.accounts.model.Customer;
import com.bankapplication.accounts.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountsController {
    @Autowired
    private AccountsRepository accountsRepository;

    @GetMapping("/account")
    public Accounts getAccountDetails(@RequestBody Customer customer){
        Accounts account = accountsRepository.findByCustomerId(customer.getCustomerId());
        if(account!=null){
            return account;
        }else{
            return null;
        }
    }
}
