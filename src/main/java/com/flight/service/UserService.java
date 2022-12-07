package com.flight.service;

import com.flight.entities.User;
import com.flight.repositories.UserJpaRepository;
import com.flight.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserJpaRepository userJpaRepository;

    public Optional<User> signUp(User user) {
        return Optional.of(userRepository.save(user));
    }

    public boolean login(String email, String password) {
        return Optional.ofNullable(userRepository.findByEmail(email))
                .map(user -> user.getPassword().equals(password))
                .orElse(false);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public List<User> searchUsers(String firstName, String lastName, String email) {
        return userJpaRepository.findUsers(firstName, lastName, email);
    }
}
