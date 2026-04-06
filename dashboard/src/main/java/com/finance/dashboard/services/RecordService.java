package com.finance.dashboard.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.*;
import com.finance.dashboard.entity.*;
import com.finance.dashboard.repository.RecordRepository;

@Service
public class RecordService {

    @Autowired
    private RecordRepository repo;

    public FinancialRecord create(FinancialRecord r) {
        return repo.save(r);
    }

    public List<FinancialRecord> getAll() {
        return repo.findAll();
    }

    public List<FinancialRecord> filterByType(Type type) {
        return repo.findByType(type);
    }

    public List<FinancialRecord> filterByCategory(String category) {
        return repo.findByCategory(category);
    }

    public List<FinancialRecord> filterByDate(LocalDate start, LocalDate end) {
        return repo.findByDateBetween(start, end);
    }

    public FinancialRecord update(Long id, FinancialRecord newData) {
        FinancialRecord r = repo.findById(id).orElseThrow();
        r.setAmount(newData.getAmount());
        r.setCategory(newData.getCategory());
        r.setType(newData.getType());
        r.setDate(newData.getDate());
        r.setDescription(newData.getDescription());
        return repo.save(r);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}