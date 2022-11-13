package com.main.entityformatting.auth.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.main.entityformatting.auth.model.User;
import com.main.entityformatting.auth.repository.UserRepo;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    private UserRepo userRepo;

    public CustomUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        User user = userRepo.findByEmail(email);
        if (user == null)
            throw new UsernameNotFoundException("Expired or invalid JWT token");

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (String role : user.getRoleAsList()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role));
        }

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                grantedAuthorities);
    }
}
