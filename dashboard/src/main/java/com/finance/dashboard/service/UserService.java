package com.finance.dashboard.service;

import com.finance.dashboard.entity.User;
import com.finance.dashboard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User register(User user) {
        return repo.save(user);
    }

    public User getByEmail(String email) {
        return repo.findByEmail(email).orElseThrow();
    }
}