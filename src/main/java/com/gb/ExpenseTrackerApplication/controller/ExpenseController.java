package com.gb.ExpenseTrackerApplication.controller;

import com.gb.ExpenseTrackerApplication.dto.ExpenseRequest;
import com.gb.ExpenseTrackerApplication.model.Expense;
import com.gb.ExpenseTrackerApplication.service.ExpenseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
@RequiredArgsConstructor
@Tag(name = "Expense APIs", description = "APIs for managing expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    // ---------------- CREATE EXPENSE ----------------
    @Operation(summary = "Add a new expense")
    @PostMapping
    public ResponseEntity<Expense> addExpense(
            @Valid @RequestBody ExpenseRequest request) {

        Expense saved = expenseService.addExpense(request);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // ---------------- MONTHLY EXPENSES ----------------
    @Operation(summary = "Get expenses for a specific month")
    @GetMapping("/monthly")
    public ResponseEntity<List<Expense>> getMonthlyExpenses(
            @RequestParam int year,
            @RequestParam int month) {

        return ResponseEntity.ok(
                expenseService.getMonthlyExpenses(year, month)
        );
    }

    // ---------------- TOTAL EXPENSE ----------------
    @Operation(summary = "Get total expense amount")
    @GetMapping("/total")
    public ResponseEntity<Double> getTotalExpense() {
        return ResponseEntity.ok(expenseService.getTotalExpense());
    }

    // ---------------- CATEGORY FILTER ----------------
    @Operation(summary = "Get expenses by category")
    @GetMapping("/category/{name}")
    public ResponseEntity<List<Expense>> getByCategory(
            @PathVariable String name) {

        return ResponseEntity.ok(
                expenseService.getByCategory(name)
        );
    }

    // ---------------- DELETE EXPENSE ----------------
    @Operation(summary = "Delete an expense by ID")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
    }
}
