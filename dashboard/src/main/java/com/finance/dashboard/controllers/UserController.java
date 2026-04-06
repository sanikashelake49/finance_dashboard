package com.finance.dashboard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.finance.dashboard.entity.User;
import com.finance.dashboard.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository repo;

    // Create User
    @PostMapping
    public User create(@RequestBody User user) {
        return repo.save(user);
    }

    // Get All Users
    @GetMapping
    public List<User> getAll() {
        return repo.findAll();
    }
}