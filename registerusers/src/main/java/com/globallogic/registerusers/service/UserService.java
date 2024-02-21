package com.globallogic.registerusers.service;

import com.globallogic.registerusers.dto.SignUpUserDto;
import com.globallogic.registerusers.entity.User;

import java.util.Optional;

public interface UserService {
    public User createUser(SignUpUserDto user);
    public Optional<User> getUserByEmail(String email);
    public User updateLastLogin(User user);
}
