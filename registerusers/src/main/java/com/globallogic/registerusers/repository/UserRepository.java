package com.globallogic.registerusers.repository;

import com.globallogic.registerusers.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    public Optional<User> findByEmail(String email);
    //public Optional<User> findByToken(String token);
}

