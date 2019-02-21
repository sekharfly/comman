package com.crud.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.demo.model.OrderDetails;

public interface OrderDetailsRepo extends JpaRepository<OrderDetails, Long> {

}
