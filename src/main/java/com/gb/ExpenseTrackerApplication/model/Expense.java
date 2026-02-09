package com.gb.ExpenseTrackerApplication.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Double amount;

    private LocalDate date;

    @ManyToOne
    private Category category;
    //    Meaning of @ManyToOne
    //
    //One category → many expenses
    //
    //DB creates category_id column
}
