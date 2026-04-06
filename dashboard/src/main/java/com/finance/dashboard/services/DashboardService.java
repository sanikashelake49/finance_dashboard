package com.finance.dashboard.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;
import com.finance.dashboard.entity.*;
import com.finance.dashboard.repository.RecordRepository;

@Service
public class DashboardService {

    @Autowired
    private RecordRepository repo;

    public Map<String, Double> summary() {
        List<FinancialRecord> list = repo.findAll();

        double income = 0, expense = 0;

        for (FinancialRecord r : list) {
            if (r.getType() == Type.INCOME) income += r.getAmount();
            else expense += r.getAmount();
        }

        Map<String, Double> map = new HashMap<>();
        map.put("totalIncome", income);
        map.put("totalExpense", expense);
        map.put("netBalance", income - expense);
        return map;
    }

    public Map<String, Double> categorySummary() {
        return repo.findAll().stream()
            .collect(Collectors.groupingBy(
                FinancialRecord::getCategory,
                Collectors.summingDouble(FinancialRecord::getAmount)
            ));
    }

    public Map<String, Double> monthlySummary() {
        return repo.findAll().stream()
            .collect(Collectors.groupingBy(
                r -> r.getDate().getMonth().toString(),
                Collectors.summingDouble(FinancialRecord::getAmount)
            ));
    }
}