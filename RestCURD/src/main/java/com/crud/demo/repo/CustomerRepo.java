package com.crud.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.demo.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
