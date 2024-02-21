package com.globallogic.registerusers.service;

import com.globallogic.registerusers.dto.SignUpUserDto;
import com.globallogic.registerusers.entity.User;
import com.globallogic.registerusers.entity.UserPhone;
import com.globallogic.registerusers.repository.UserRepository;
import com.globallogic.registerusers.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User createUser(SignUpUserDto uDto) {

        List<UserPhone> userPhones = Optional.ofNullable(uDto.getPhones())
                .orElse(Collections.emptyList())
                .stream()
                .map(phoneDto -> new UserPhone(phoneDto.getNumber(), phoneDto.getCitycode(), phoneDto.getCountrycode()))
                .collect(Collectors.toList());

        User newUser = new User(uDto.getName(), uDto.getEmail(), uDto.getPassword(), userPhones);
        newUser.setCreated(new Date());
        newUser.setModified(new Date());
        newUser.setLastLogin(new Date());
        userPhones.stream().forEach(phone -> phone.setUser(newUser));

        return userRepository.save(newUser);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User updateLastLogin(User loginUser) {
        loginUser.setLastLogin(new Date());
        return userRepository.save(loginUser);
    }

}
