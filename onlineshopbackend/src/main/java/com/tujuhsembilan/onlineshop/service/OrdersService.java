package com.tujuhsembilan.onlineshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tujuhsembilan.onlineshop.model.Orders;
import com.tujuhsembilan.onlineshop.repository.OrdersRepository;

@Service
public class OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;

    public List<Orders> findAll(){
        return ordersRepository.findAll();
    }

    public Orders findById(Integer id) {
        return ordersRepository.findById(id).orElse(null);
    }
    
    public Orders save(Orders orders) {
        return ordersRepository.save(orders);
    }
    
    public void deleteById(Integer id) {
        ordersRepository.deleteById(id);
    }
}
