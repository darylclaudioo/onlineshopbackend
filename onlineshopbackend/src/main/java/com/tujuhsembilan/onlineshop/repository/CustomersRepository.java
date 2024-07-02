package com.tujuhsembilan.onlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tujuhsembilan.onlineshop.model.Customers;

public interface CustomersRepository extends JpaRepository<Customers, Integer> {
    
}
