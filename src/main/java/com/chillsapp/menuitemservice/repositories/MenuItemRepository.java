package com.chillsapp.menuitemservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.chillsapp.menuitemservice.documents.MenuItem;

public interface MenuItemRepository extends MongoRepository<MenuItem, String>  {
    
}
