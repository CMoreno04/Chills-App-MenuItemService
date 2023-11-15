package com.chillsapp.menuitemservice.services.impl;

import java.util.List;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import com.chillsapp.menuitemservice.documents.MenuItem;
import com.chillsapp.menuitemservice.repositories.MenuItemRepository;
import com.chillsapp.menuitemservice.services.MenuItemService;

@Service
public class MenuitemServiceImpl implements MenuItemService {

    private MenuItemRepository menuItemRepository;

    public MenuitemServiceImpl(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    @Override
    public List<MenuItem> getAllMenuItem() {
        return this.menuItemRepository.findAll();
    }

    @Override
    public List<MenuItem> createMenuItem(MenuItem menuItem) {
        try {
            this.menuItemRepository.insert(menuItem);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.menuItemRepository.findAll();
    }

    @Override
    public List<MenuItem> updateMenuItem(String id, MenuItem menuItem) {
        try {
            this.menuItemRepository.save(menuItem);
        } catch (IllegalArgumentException | OptimisticLockingFailureException e) {
            e.printStackTrace();
        }
        return this.menuItemRepository.findAll();
    }

    @Override
    public List<MenuItem> deleteMenuItem(String id) {
        try {
            this.menuItemRepository.deleteById(id);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return this.menuItemRepository.findAll();
    }

}
