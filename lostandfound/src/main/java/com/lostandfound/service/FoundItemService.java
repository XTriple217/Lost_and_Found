package com.lostandfound.service;

import com.lostandfound.entity.FoundItem;
import com.lostandfound.repository.FoundItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Nkurikiyimana Aimable
 * Reg No: 24582/2024
 */
@Service
public class FoundItemService {

    @Autowired
    private FoundItemRepository foundItemRepository;

    public FoundItem reportFoundItem(FoundItem item) {
        return foundItemRepository.save(item);
    }

    public List<FoundItem> getAllFoundItems() {
        return foundItemRepository.findAll();
    }

    public FoundItem getFoundItemById(Long id) {
        return foundItemRepository.findById(id).orElse(null);
    }

    public void deleteFoundItem(Long id) {
        foundItemRepository.deleteById(id);
    }
    public FoundItem approveFoundItem(Long id) {
        FoundItem item = getFoundItemById(id);
        item.setStatus("approved");
        return foundItemRepository.save(item);
    }

    public FoundItem rejectFoundItem(Long id) {
        FoundItem item = getFoundItemById(id);
        item.setStatus("rejected");
        return foundItemRepository.save(item);
    }

}
