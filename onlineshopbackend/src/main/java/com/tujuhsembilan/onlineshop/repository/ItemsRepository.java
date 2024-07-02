package com.tujuhsembilan.onlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tujuhsembilan.onlineshop.model.Items;

public interface ItemsRepository extends JpaRepository<Items, Integer> {
    
}
