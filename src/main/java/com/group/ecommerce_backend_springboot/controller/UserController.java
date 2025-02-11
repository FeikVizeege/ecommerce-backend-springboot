package com.group.ecommerce_backend_springboot.controller;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group.ecommerce_backend_springboot.model.User;
import com.group.ecommerce_backend_springboot.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        var convertId = new ObjectId(id);
        Optional<User> user = userService.getUserById(convertId);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUsername(@PathVariable String id, @RequestBody String username) {
        var convertId = new ObjectId(id);
        return userService.updateUsername(convertId, username)
            .map(updatedUser -> ResponseEntity.ok(updatedUser))
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable String id) {
        var convertId = new ObjectId(id);
        try {
            userService.deleteUserById(convertId);
            return ResponseEntity.ok("User deleted successfully.");
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
