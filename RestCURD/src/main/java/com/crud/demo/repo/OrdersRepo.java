package com.crud.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.demo.model.Orders;

public interface OrdersRepo extends JpaRepository<Orders, Long>{

}
