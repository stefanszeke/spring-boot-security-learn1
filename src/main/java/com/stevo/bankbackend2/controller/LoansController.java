package com.stevo.bankbackend2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {
  
  @GetMapping("/MyLoans")
  public String getLoanDetails() {
    return "My Loans";
  }
}
