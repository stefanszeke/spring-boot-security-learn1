package com.stevo.bankbackend2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

  @GetMapping("/MyAccount")
  public String getAccountDetails() {
    return "My Account Details";
  }

}
