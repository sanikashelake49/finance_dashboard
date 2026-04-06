package com.finance.dashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;
import com.finance.dashboard.entity.*;

public interface RecordRepository extends JpaRepository<FinancialRecord, Long> {

    List<FinancialRecord> findByType(Type type);
    List<FinancialRecord> findByCategory(String category);

    List<FinancialRecord> findByDateBetween(LocalDate start, LocalDate end);
}