package com.finance.dashboard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import com.finance.dashboard.services.DashboardService;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService service;

    @GetMapping("/summary")
    public Map<String, Double> summary() {
        return service.summary();
    }

    @GetMapping("/category")
    public Map<String, Double> category() {
        return service.categorySummary();
    }

    @GetMapping("/monthly")
    public Map<String, Double> monthly() {
        return service.monthlySummary();
    }
}