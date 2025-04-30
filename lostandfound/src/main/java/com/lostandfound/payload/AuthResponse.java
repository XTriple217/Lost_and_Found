package com.lostandfound.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Author: Nkurikiyimana Aimable
 * Reg No: 24582/2024
 */
@Data
@AllArgsConstructor
public class AuthResponse {
    private int status;
    private String token;
}
