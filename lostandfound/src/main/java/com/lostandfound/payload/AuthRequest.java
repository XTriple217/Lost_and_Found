package com.lostandfound.payload;

import lombok.Data;

/**
 * Author: Nkurikiyimana Aimable
 * Reg No: 24582/2024
 */
@Data
public class AuthRequest {
    private String email;
    private String password;
}
