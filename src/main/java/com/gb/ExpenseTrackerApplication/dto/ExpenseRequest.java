package com.gb.ExpenseTrackerApplication.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ExpenseRequest {

    private String title;
    private Double amount;
    private LocalDate date;
    private Long categoryId;
}
