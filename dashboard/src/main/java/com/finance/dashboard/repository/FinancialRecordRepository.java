package com.finance.dashboard.repository;

import com.finance.dashboard.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface FinancialRecordRepository extends JpaRepository<FinancialRecord, Long> {

    List<FinancialRecord> findByType(RecordType type);
    List<FinancialRecord> findByCategory(String category);
    List<FinancialRecord> findByDateBetween(LocalDate start, LocalDate end);
}