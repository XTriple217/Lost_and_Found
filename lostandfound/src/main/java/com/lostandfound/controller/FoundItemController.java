package com.lostandfound.controller;

import com.lostandfound.entity.FoundItem;
import com.lostandfound.service.FoundItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: Nkurikiyimana Aimable
 * Reg No: 24582/2024
 */
@RestController
@RequestMapping("/api/v1/founditems")
public class FoundItemController {

    @Autowired
    private FoundItemService foundItemService;

    @PostMapping
    public FoundItem reportFoundItem(@RequestBody FoundItem item) {
        return foundItemService.reportFoundItem(item);
    }

    @GetMapping
    public List<FoundItem> getAllFoundItems() {
        return foundItemService.getAllFoundItems();
    }

    @GetMapping("/{id}")
    public FoundItem getFoundItem(@PathVariable Long id) {
        return foundItemService.getFoundItemById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteFoundItem(@PathVariable Long id) {
        foundItemService.deleteFoundItem(id);
        return "Found item deleted successfully";
    }

}
