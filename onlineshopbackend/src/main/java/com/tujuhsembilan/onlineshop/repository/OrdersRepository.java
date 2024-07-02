package com.tujuhsembilan.onlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tujuhsembilan.onlineshop.model.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {
    
}
