package com.finance.dashboard.service;

import com.finance.dashboard.entity.*;
import com.finance.dashboard.repository.FinancialRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinancialRecordService {

    @Autowired
    private FinancialRecordRepository repo;

    public FinancialRecord create(FinancialRecord record) {
        return repo.save(record);
    }

    public Page<FinancialRecord> getAll(int page, int size) {
        return repo.findAll(PageRequest.of(page, size));
    }

    public List<FinancialRecord> filter(RecordType type, String category) {
        if (type != null) return repo.findByType(type);
        if (category != null) return repo.findByCategory(category);
        return repo.findAll();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}