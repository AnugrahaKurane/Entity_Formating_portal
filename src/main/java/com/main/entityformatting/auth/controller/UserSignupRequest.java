package com.main.entityformatting.auth.controller;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserSignupRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    protected UserSignupRequest() {

    }
}
