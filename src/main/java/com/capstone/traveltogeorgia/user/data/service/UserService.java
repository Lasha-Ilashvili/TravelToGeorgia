package com.capstone.traveltogeorgia.user.data.service;

import com.capstone.traveltogeorgia.user.data.model.UserEntity;
import com.capstone.traveltogeorgia.user.data.repository.UserRepository;
import com.capstone.traveltogeorgia.user.domain.model.Role;
import com.capstone.traveltogeorgia.user.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(String username, String email, String password) throws Exception {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new Exception("Username is already taken");
        }

        if (userRepository.findByEmail(email).isPresent()) {
            throw new Exception("Email is already registered");
        }

        UserEntity newUser = new UserEntity();
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setPassword(passwordEncoder.encode(password));
        newUser.setRole(Role.USER);

        userRepository.save(newUser);
    }

    public User findByUsername(String username) {
        return toDomain(Objects.requireNonNull(userRepository.findByUsername(username).orElse(null)));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll().stream().map(UserService::toDomain).toList();
    }

    private static User toDomain(UserEntity entity) {
        return new User(entity.getId(), entity.getUsername(), entity.getPassword(), entity.getEmail(), entity.getRole());
    }
}