package com.main.entityformatting.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.main.entityformatting.auth.controller.LoginRequest;
import com.main.entityformatting.auth.controller.LoginResponse;
import com.main.entityformatting.auth.controller.UserSignupRequest;
import com.main.entityformatting.auth.jwt.JwtTokenGenerator;
import com.main.entityformatting.auth.model.User;
import com.main.entityformatting.auth.repository.UserRepo;
import com.main.entityformatting.exceptions.BadRequestException;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenGenerator jwtTokenGenerator;

    public LoginResponse signup(UserSignupRequest userSignupRequest) {
        try {
            String firstName = userSignupRequest.getFirstName();
            String lastName = userSignupRequest.getLastName();
            String email = userSignupRequest.getEmail();
            String password = userSignupRequest.getPassword();

            User user = userRepo.findByEmail(email);
            if (user != null) {
                throw new BadRequestException("email already exists");
            }
            User _user = new User(firstName, lastName, email, passwordEncoder.encode(password));
            _user = userRepo.save(_user);
            String token = jwtTokenGenerator.createToken(_user.getEmail(), _user.getRoleAsList());
            return new LoginResponse(email, token);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid email/password");
        }
    }

    public LoginResponse signin(LoginRequest loginRequest) {
        try {
            String email = loginRequest.getEmail();
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(email, loginRequest.getPassword()));
            String token = jwtTokenGenerator.createToken(email,
                    this.userRepo.findByEmail(email).getRoleAsList());

            return new LoginResponse(email, token);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password");
        }
    }

}
