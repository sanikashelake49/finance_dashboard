package com.finance.dashboard.controller;

import com.finance.dashboard.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService service;

    @GetMapping
    public Map<String, Object> getSummary() {
        return service.summary();
    }
}