package com.tujuhsembilan.onlineshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tujuhsembilan.onlineshop.model.Customers;
import com.tujuhsembilan.onlineshop.repository.CustomersRepository;

@Service
public class CustomersService {
    @Autowired
    private CustomersRepository customersRepository;

    public List<Customers> findAll() {
        return customersRepository.findAll();
    }

    public Customers findById(Integer id) {
        return customersRepository.findById(id).orElse(null);
    }
    
    public Customers save(Customers customers) {
        return customersRepository.save(customers);
    }
    
    public void deleteById(Integer id) {
        customersRepository.deleteById(id);
    }
}
