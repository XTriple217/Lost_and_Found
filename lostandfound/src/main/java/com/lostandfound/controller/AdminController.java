package com.lostandfound.controller;

import com.lostandfound.entity.FoundItem;
import com.lostandfound.entity.LostItem;
import com.lostandfound.entity.User;
import com.lostandfound.service.FoundItemService;
import com.lostandfound.service.LostItemService;
import com.lostandfound.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: Nkurikiyimana Aimable
 * Reg No: 24582/2024
 */
@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private LostItemService lostItemService;

    @Autowired
    private FoundItemService foundItemService;

    @PatchMapping("/ban/{id}")
    public User banUser(@PathVariable Long id) {
        return userService.banUser(id);
    }

    @PatchMapping("/unban/{id}")
    public User unbanUser(@PathVariable Long id) {
        return userService.unbanUser(id);
    }

    @PatchMapping("/lostitems/{id}/approve")
    public LostItem approveLostItem(@PathVariable Long id) {
        return lostItemService.approveLostItem(id);
    }

    @PatchMapping("/lostitems/{id}/reject")
    public LostItem rejectLostItem(@PathVariable Long id) {
        return lostItemService.rejectLostItem(id);
    }

    @PatchMapping("/founditems/{id}/approve")
    public FoundItem approveFoundItem(@PathVariable Long id) {
        return foundItemService.approveFoundItem(id);
    }

    @PatchMapping("/founditems/{id}/reject")
    public FoundItem rejectFoundItem(@PathVariable Long id) {
        return foundItemService.rejectFoundItem(id);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
