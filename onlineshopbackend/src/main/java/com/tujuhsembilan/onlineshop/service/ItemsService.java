package com.tujuhsembilan.onlineshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tujuhsembilan.onlineshop.model.Items;
import com.tujuhsembilan.onlineshop.repository.ItemsRepository;

@Service
public class ItemsService {
    @Autowired
    private ItemsRepository itemsRepository;

    public List<Items> findAll(){
        return itemsRepository.findAll();
    }

    public Items findById(Integer id) {
        return itemsRepository.findById(id).orElse(null);
    }
    
    public Items save(Items items) {
        return itemsRepository.save(items);
    }
    
    public void deleteById(Integer id) {
        itemsRepository.deleteById(id);
    }
}
