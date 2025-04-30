package com.lostandfound.controller;

import com.lostandfound.entity.LostItem;
import com.lostandfound.service.LostItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: Nkurikiyimana Aimable
 * Reg No: 24582/2024
 */
@RestController
@RequestMapping("/api/v1/lostitems")
public class LostItemController {

    @Autowired
    private LostItemService lostItemService;

    @PostMapping
    public LostItem reportLostItem(@RequestBody LostItem lostItem) {
        return lostItemService.reportLostItem(lostItem);
    }

    @GetMapping
    public List<LostItem> getAllLostItems() {
        return lostItemService.getAllLostItems();
    }

    @GetMapping("/{id}")
    public LostItem getLostItem(@PathVariable Long id) {
        return lostItemService.getLostItemById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteLostItem(@PathVariable Long id) {
        lostItemService.deleteLostItem(id);
        return "Lost item deleted successfully";
    }
}
