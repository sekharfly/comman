package com.crud.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.demo.model.Products;

public interface ProductsRepo extends JpaRepository<Products, Long> {

}
