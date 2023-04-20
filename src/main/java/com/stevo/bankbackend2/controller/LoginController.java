package com.stevo.bankbackend2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stevo.bankbackend2.model.Customer;
import com.stevo.bankbackend2.repository.CustomerRepository;

@RestController
public class LoginController {

  @Autowired
  CustomerRepository customerRepository;

  @PostMapping("/register")
  public ResponseEntity<String> registerUser(@RequestBody Customer customer) {

    Customer savedCustomer = null;
    ResponseEntity<String> response = null;

    try {
      savedCustomer = customerRepository.save(customer);

      if (savedCustomer.getId() > 0) {
        response = ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
      }
    } catch (Exception e) {
      response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error registering user: " + e.getMessage());
    }

    return response;
  }

}
