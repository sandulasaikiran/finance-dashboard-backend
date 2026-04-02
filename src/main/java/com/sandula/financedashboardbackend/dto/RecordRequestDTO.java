package com.sandula.financedashboardbackend.dto;

import java.time.LocalDate;

import com.sandula.financedashboardbackend.entity.RecordType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class RecordRequestDTO {

    @NotNull
    @Positive
    private Double amount;

    @NotNull
    private RecordType type;

    @NotBlank
    private String category;

    @NotNull
    private LocalDate date;

    private String description;
}