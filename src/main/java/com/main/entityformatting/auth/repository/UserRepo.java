package com.main.entityformatting.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.main.entityformatting.auth.model.User;

public interface UserRepo extends JpaRepository<User, Long> {

    User findByEmail(String email);

    Boolean existsByEmail(String email);

}
