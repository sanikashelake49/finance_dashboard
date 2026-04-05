package com.finance.dashboard.controller;

import com.finance.dashboard.entity.User;
import com.finance.dashboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public User create(@RequestBody User user) {
        return service.register(user);
    }
}