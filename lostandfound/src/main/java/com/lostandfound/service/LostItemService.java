package com.lostandfound.service;

import com.lostandfound.entity.LostItem;
import com.lostandfound.repository.LostItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Nkurikiyimana Aimable
 * Reg No: 24582/2024
 */
@Service
public class LostItemService {

    @Autowired
    private LostItemRepository lostItemRepository;

    public LostItem reportLostItem(LostItem lostItem) {
        return lostItemRepository.save(lostItem);
    }

    public List<LostItem> getAllLostItems() {
        return lostItemRepository.findAll();
    }

    public LostItem getLostItemById(Long id) {
        return lostItemRepository.findById(id).orElse(null);
    }

    public void deleteLostItem(Long id) {
        lostItemRepository.deleteById(id);
    }
    public LostItem approveLostItem(Long id) {
        LostItem item = getLostItemById(id);
        item.setStatus("approved");
        return lostItemRepository.save(item);
    }

    public LostItem rejectLostItem(Long id) {
        LostItem item = getLostItemById(id);
        item.setStatus("rejected");
        return lostItemRepository.save(item);
    }

}
