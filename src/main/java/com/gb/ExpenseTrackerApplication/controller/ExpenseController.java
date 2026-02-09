package com.gb.ExpenseTrackerApplication.controller;

import com.gb.ExpenseTrackerApplication.dto.ExpenseRequest;
import com.gb.ExpenseTrackerApplication.model.Expense;
import com.gb.ExpenseTrackerApplication.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;

    @PostMapping
    public Expense add(@RequestBody ExpenseRequest request) {
        return expenseService.addExpense(request);
    }

    @GetMapping("/monthly")
    public List<Expense> monthly(
            @RequestParam int year,
            @RequestParam int month) {
        return expenseService.getMonthlyExpenses(year, month);
    }

    @GetMapping("/total")
    public Double total() {
        return expenseService.getTotalExpense();
    }

    @GetMapping("/category/{name}")
    public List<Expense> byCategory(
            @PathVariable String name) {
        return expenseService.getByCategory(name);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        expenseService.deleteExpense(id);
    }
}
