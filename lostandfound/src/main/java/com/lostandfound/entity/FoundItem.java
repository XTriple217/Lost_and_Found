package com.lostandfound.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

/**
 * Author: Nkurikiyimana Aimable
 * Reg No: 24582/2024
 */
@Entity
@Data
public class FoundItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemName;
    private String description;
    private String location;
    private String category;

    @Temporal(TemporalType.DATE)
    private Date foundDate;

    @ManyToOne
    private User user;

    private String status = "pending"; // pending, approved, rejected
}
