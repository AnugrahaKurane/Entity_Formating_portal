package com.main.entityformatting.auth.controller;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginRequest {

    private String email;
    private String password;

    protected LoginRequest() {

    }

}
