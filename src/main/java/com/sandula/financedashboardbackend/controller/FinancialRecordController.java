package com.sandula.financedashboardbackend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sandula.financedashboardbackend.dto.RecordRequestDTO;
import com.sandula.financedashboardbackend.entity.FinancialRecord;
import com.sandula.financedashboardbackend.entity.RecordType;
import com.sandula.financedashboardbackend.service.FinancialRecordService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/records")
@RequiredArgsConstructor
public class FinancialRecordController {

    private final FinancialRecordService financialRecordService;

    @PostMapping
    public ResponseEntity<FinancialRecord> createRecord(
            @Valid @RequestBody RecordRequestDTO dto) {
        return ResponseEntity.ok(financialRecordService.createRecord(dto));
    }

    @GetMapping
    public ResponseEntity<List<FinancialRecord>> getAllRecords() {
        return ResponseEntity.ok(financialRecordService.getAllRecords());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FinancialRecord> getRecordById(@PathVariable Long id) {
        return ResponseEntity.ok(financialRecordService.getRecordById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FinancialRecord> updateRecord(
            @PathVariable Long id,
            @Valid @RequestBody RecordRequestDTO dto) {
        return ResponseEntity.ok(financialRecordService.updateRecord(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRecord(@PathVariable Long id) {
        financialRecordService.deleteRecord(id);
        return ResponseEntity.ok("Record deleted successfully");
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<FinancialRecord>> getByType(
            @PathVariable RecordType type) {
        return ResponseEntity.ok(financialRecordService.getByType(type));
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<FinancialRecord>> getByCategory(
            @PathVariable String category) {
        return ResponseEntity.ok(financialRecordService.getByCategory(category));
    }
}