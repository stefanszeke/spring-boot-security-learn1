package com.stevo.bankbackend2.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stevo.bankbackend2.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
  
  List<Customer> findByEmail(String email);
}
