package com.main.entityformatting.auth.controller;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserSignupReponse {
    private String email;
    private String token;

    protected UserSignupReponse() {

    }
}
