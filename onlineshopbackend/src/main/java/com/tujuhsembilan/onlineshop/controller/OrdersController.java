package com.tujuhsembilan.onlineshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tujuhsembilan.onlineshop.model.Orders;
import com.tujuhsembilan.onlineshop.service.OrdersService;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @GetMapping
    public ResponseEntity<List<Orders>> getAllOrders() {
        List<Orders> orders = ordersService.findAll();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orders> getOrderById(@PathVariable Integer id) {
        Orders Orders = ordersService.findById(id);
        if (Orders != null) {
            return ResponseEntity.ok(Orders);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping
    public Orders createOrder(@RequestBody Orders Orders) {
        return ordersService.save(Orders);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Orders> updateOrder(@PathVariable Integer id, @RequestBody Orders orderDetails) {
        Orders Orders = ordersService.findById(id);
        if (Orders != null) {
            Orders.setOrderCode(orderDetails.getOrderCode());
            Orders.setOrderDate(orderDetails.getOrderDate());
            Orders.setQuantity(orderDetails.getQuantity());
            Orders.setCustomers(orderDetails.getCustomers());
            Orders.setItems(orderDetails.getItems());
            Orders.calculateTotalPrice();
            return ResponseEntity.ok(ordersService.save(Orders));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Integer id) {
        Orders Orders = ordersService.findById(id);
        if (Orders != null) {
            ordersService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
