package com.java.authentication.api.dto;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}