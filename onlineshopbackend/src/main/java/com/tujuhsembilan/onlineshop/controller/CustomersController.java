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

import com.tujuhsembilan.onlineshop.model.Customers;
import com.tujuhsembilan.onlineshop.service.CustomersService;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {
    @Autowired
    private CustomersService customersService;

    @GetMapping
    public ResponseEntity<List<Customers>> getAllCustomers() {
        List<Customers> customers = customersService.findAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customers> getCustomerById(@PathVariable Integer id) {
        Customers customers = customersService.findById(id);
        if (customers != null) {
            return ResponseEntity.ok(customers);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Customers createCustomer(@RequestBody Customers customers) {
        return customersService.save(customers);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customers> updateCustomer(@PathVariable Integer id, @RequestBody Customers customersDetails) {
        Customers customers = customersService.findById(id);
        if (customers != null) {
            customers.setCustomerName(customersDetails.getCustomerName());
            customers.setCustomerAddress(customersDetails.getCustomerAddress());
            customers.setCustomerCode(customersDetails.getCustomerCode());
            customers.setCustomerPhone(customersDetails.getCustomerPhone());
            customers.setIsActive(customersDetails.getIsActive());
            customers.setLastOrderDate(customersDetails.getLastOrderDate());
            customers.setPic(customersDetails.getPic());
            return ResponseEntity.ok(customersService.save(customers));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Integer id) {
        Customers customers = customersService.findById(id);
        if (customers != null) {
            customersService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
