package com.bankapplication.accounts.client;

import java.util.List;

import com.bankapplication.accounts.model.Customer;
import com.bankapplication.accounts.model.Loans;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("LOANS")
public interface LoansFeignClient {

    @RequestMapping(method = RequestMethod.POST, value = "loans", consumes = "application/json")
    List<Loans> getLoansDetails(@RequestHeader("bank-correlation-id") String correlationid, @RequestBody Customer customer);
}
