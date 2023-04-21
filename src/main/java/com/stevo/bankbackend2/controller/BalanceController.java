package com.stevo.bankbackend2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stevo.bankbackend2.model.AccountTransactions;
import com.stevo.bankbackend2.repository.AccountTransactionsRepository;

@RestController
public class BalanceController {

  @Autowired AccountTransactionsRepository accountTransactionsRepository;


  @GetMapping("/MyBalance")
  public List<AccountTransactions> getBalanceDetails(@RequestParam int id) {
    List<AccountTransactions> accountTransactions = accountTransactionsRepository.findByCustomerIdOrderByTransactionDtDesc(id);

    if(accountTransactions == null) { return null; }

    return accountTransactions;
  }
  
}
