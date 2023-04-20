package com.stevo.bankbackend2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {
  
  @GetMapping("/MyCards")
  public String getCardDetails() {
    return "My Cards";
  }
}
