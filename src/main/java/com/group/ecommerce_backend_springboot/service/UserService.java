package com.group.ecommerce_backend_springboot.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.group.ecommerce_backend_springboot.model.User;
import com.group.ecommerce_backend_springboot.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUser(User user) {
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        return userRepository.save(user);
    }

    public Optional<User> getUserById(ObjectId id) {
        return userRepository.findById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> updateUsername(ObjectId id, String username) {
        return userRepository.findById(id).map(user -> {
            user.setUsername(username);
            return userRepository.save(user);
        });
    }

    public void deleteUserById(ObjectId id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) userRepository.delete(user.get());
        else throw new RuntimeException("User not found");
    }

}
