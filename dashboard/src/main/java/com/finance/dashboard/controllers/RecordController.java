package com.finance.dashboard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import com.finance.dashboard.entity.*;
import com.finance.dashboard.services.RecordService;

@RestController
@RequestMapping("/records")
public class RecordController {

    @Autowired
    private RecordService service;

    @PostMapping
    public FinancialRecord create(@RequestBody FinancialRecord r) {
        return service.create(r);
    }

    @GetMapping
    public List<FinancialRecord> getAll() {
        return service.getAll();
    }

    @GetMapping("/type/{type}")
    public List<FinancialRecord> byType(@PathVariable Type type) {
        return service.filterByType(type);
    }

    @GetMapping("/category/{cat}")
    public List<FinancialRecord> byCategory(@PathVariable String cat) {
        return service.filterByCategory(cat);
    }

    @GetMapping("/date")
    public List<FinancialRecord> byDate(
        @RequestParam LocalDate start,
        @RequestParam LocalDate end) {
        return service.filterByDate(start, end);
    }

    @PutMapping("/{id}")
    public FinancialRecord update(@PathVariable Long id, @RequestBody FinancialRecord r) {
        return service.update(id, r);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}