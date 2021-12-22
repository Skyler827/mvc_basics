package com.example.mvcbasics.services;

import com.example.mvcbasics.entities.User;
import com.example.mvcbasics.mapper.UserMapper;

import java.security.SecureRandom;
import java.util.Base64;

public class UserService {
    HashService hashService;
    UserMapper userMapper;

    public UserService(HashService hashService, UserMapper userMapper) {
        this.hashService = hashService;
        this.userMapper = userMapper;
    }
    public int createUser(User user) {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        String encodedSalt = Base64.getEncoder().encodeToString(salt);
        String hashedPassword = hashService.getHashedValue(user.getPassword(), encodedSalt);
        return userMapper.insert(new User(
            null,
            user.getUsername(),
            user.getSalt(),
            null,
            hashedPassword,
            user.getFirstName(),
            user.getLastName()
        ));
    }
}
