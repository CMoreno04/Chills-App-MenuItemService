package com.chillsapp.menuitemservice.services;

import java.util.List;

import com.chillsapp.menuitemservice.documents.MenuItem;

public interface MenuItemService {
    public List<MenuItem> getAllMenuItem();

    public List<MenuItem> createMenuItem(MenuItem menuItem);

    public List<MenuItem> updateMenuItem(String id, MenuItem menuItem);

    public List<MenuItem> deleteMenuItem(String id);

}
