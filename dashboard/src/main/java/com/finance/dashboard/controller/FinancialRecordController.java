package com.finance.dashboard.controller;

import com.finance.dashboard.entity.*;
import com.finance.dashboard.service.FinancialRecordService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/records")
public class FinancialRecordController {

    @Autowired
    private FinancialRecordService service;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public FinancialRecord create(@Valid @RequestBody FinancialRecord record) {
        return service.create(record);
    }

    @PreAuthorize("hasAnyRole('ADMIN','ANALYST','VIEWER')")
    @GetMapping
    public Page<FinancialRecord> getAll(
            @RequestParam int page,
            @RequestParam int size) {
        return service.getAll(page, size);
    }

    @PreAuthorize("hasAnyRole('ADMIN','ANALYST')")
    @GetMapping("/filter")
    public Object filter(
            @RequestParam(required = false) RecordType type,
            @RequestParam(required = false) String category) {
        return service.filter(type, category);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}