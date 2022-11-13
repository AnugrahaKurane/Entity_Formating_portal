package com.main.entityformatting.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.main.entityformatting.auth.jwt.JwtTokenGenerator;
import com.main.entityformatting.auth.repository.UserRepo;
import com.main.entityformatting.auth.service.UserService;
import com.main.entityformatting.exceptions.CustomException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class UserController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenGenerator jwtTokenGenerator;

    @Autowired
    UserRepo userRepo;

    @Autowired
    UserService userService;

    @ResponseStatus(code = HttpStatus.OK)
    @RequestMapping(value = "/api/auth/login", method = RequestMethod.POST)
    public ResponseEntity<LoginResponse> signin(@RequestBody LoginRequest loginRequest) {
        return new ResponseEntity<>(userService.signin(loginRequest), HttpStatus.OK);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @RequestMapping(value = "/api/auth/signup", method = RequestMethod.POST)
    public ResponseEntity<LoginResponse> signup(@RequestBody UserSignupRequest userSignupRequest) {
        return new ResponseEntity<>(userService.signup(userSignupRequest), HttpStatus.OK);
    }
}
