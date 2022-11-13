package com.main.entityformatting.auth.controller;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {
    private String email;
    private String token;

    protected LoginResponse() {

    }
}
