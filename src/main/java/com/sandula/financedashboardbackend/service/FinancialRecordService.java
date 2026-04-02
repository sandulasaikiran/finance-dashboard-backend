package com.sandula.financedashboardbackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sandula.financedashboardbackend.dto.RecordRequestDTO;
import com.sandula.financedashboardbackend.entity.FinancialRecord;
import com.sandula.financedashboardbackend.entity.RecordType;
import com.sandula.financedashboardbackend.repository.FinancialRecordRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FinancialRecordService {

    private final FinancialRecordRepository financialRecordRepository;

    public FinancialRecord createRecord(RecordRequestDTO dto) {
        FinancialRecord record = new FinancialRecord();
        record.setAmount(dto.getAmount());
        record.setType(dto.getType());
        record.setCategory(dto.getCategory());
        record.setDate(dto.getDate());
        record.setDescription(dto.getDescription());

        return financialRecordRepository.save(record);
    }

    public List<FinancialRecord> getAllRecords() {
        return financialRecordRepository.findAll();
    }

    public FinancialRecord getRecordById(Long id) {
        return financialRecordRepository.findById(id).orElseThrow();
    }

    public FinancialRecord updateRecord(Long id, RecordRequestDTO dto) {
        FinancialRecord record = financialRecordRepository.findById(id)
                .orElseThrow();

        record.setAmount(dto.getAmount());
        record.setType(dto.getType());
        record.setCategory(dto.getCategory());
        record.setDate(dto.getDate());
        record.setDescription(dto.getDescription());

        return financialRecordRepository.save(record);
    }

    public void deleteRecord(Long id) {
        financialRecordRepository.deleteById(id);
    }

    public List<FinancialRecord> getByType(RecordType type) {
        return financialRecordRepository.findByType(type);
    }

    public List<FinancialRecord> getByCategory(String category) {
        return financialRecordRepository.findByCategory(category);
    }
}