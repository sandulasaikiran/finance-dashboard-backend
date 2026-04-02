package com.sandula.financedashboardbackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sandula.financedashboardbackend.dto.DashboardSummaryDTO;
import com.sandula.financedashboardbackend.entity.FinancialRecord;
import com.sandula.financedashboardbackend.entity.RecordType;
import com.sandula.financedashboardbackend.repository.FinancialRecordRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final FinancialRecordRepository financialRecordRepository;

    public DashboardSummaryDTO getSummary() {
        List<FinancialRecord> records = financialRecordRepository.findAll();

        double totalIncome = records.stream()
                .filter(r -> r.getType() == RecordType.INCOME)
                .mapToDouble(FinancialRecord::getAmount)
                .sum();

        double totalExpense = records.stream()
                .filter(r -> r.getType() == RecordType.EXPENSE)
                .mapToDouble(FinancialRecord::getAmount)
                .sum();

        double netBalance = totalIncome - totalExpense;

        return new DashboardSummaryDTO(totalIncome, totalExpense, netBalance);
    }
}