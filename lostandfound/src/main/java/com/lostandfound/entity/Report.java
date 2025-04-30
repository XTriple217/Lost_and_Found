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
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private LostItem lostItem;

    @ManyToOne
    private FoundItem foundItem;

    @ManyToOne
    private User reporter;

    private String status = "new"; // new, reviewed, closed

    @Temporal(TemporalType.TIMESTAMP)
    private Date reportedAt = new Date();
}
