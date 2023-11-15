package com.chillsapp.menuitemservice.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chillsapp.menuitemservice.documents.MenuItem;
import com.chillsapp.menuitemservice.services.MenuItemService;

@RestController
@RequestMapping("/api/food")
public class MenuItemController {

    private final MenuItemService MenuItemService;

    public MenuItemController(MenuItemService menuItemService) {
        MenuItemService = menuItemService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<MenuItem>> getAllMenuItems() {
        return ResponseEntity.ok(this.MenuItemService.getAllMenuItem());
    }

    @PostMapping("/create")
    public ResponseEntity<List<MenuItem>> createMenuItem(@RequestBody MenuItem menuItem) {
        return ResponseEntity.ok(this.MenuItemService.createMenuItem(menuItem));
    }

    @PostMapping("/update")
    public ResponseEntity<List<MenuItem>> updateMenuItem(@RequestBody String id, @RequestBody MenuItem menuItem) {
        return ResponseEntity.ok(this.MenuItemService.updateMenuItem(id, menuItem));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<List<MenuItem>> updateMenuItem(@RequestBody String id) {
        return ResponseEntity.ok(this.MenuItemService.deleteMenuItem(id));
    }
}
