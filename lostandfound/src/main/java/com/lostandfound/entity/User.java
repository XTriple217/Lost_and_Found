package com.lostandfound.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Author: Nkurikiyimana Aimable
 * Reg No: 24582/2024
 */
@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    private String password;
    private String fullName;
    private boolean isAdmin = false;
    private boolean isBanned = false;
}
