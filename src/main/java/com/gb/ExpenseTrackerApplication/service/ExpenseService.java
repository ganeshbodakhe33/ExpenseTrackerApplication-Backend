package com.gb.ExpenseTrackerApplication.service;

import com.gb.ExpenseTrackerApplication.dto.ExpenseRequest;
import com.gb.ExpenseTrackerApplication.model.Category;
import com.gb.ExpenseTrackerApplication.model.Expense;
import com.gb.ExpenseTrackerApplication.repository.CategoryRepository;
import com.gb.ExpenseTrackerApplication.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final CategoryRepository categoryRepository;

    public Expense addExpense(ExpenseRequest request) {

        Category category = categoryRepository
                .findById(request.getCategoryId())
                .orElseThrow(() ->
                        new RuntimeException("Category not found"));

        Expense expense = new Expense();
        expense.setTitle(request.getTitle());
        expense.setAmount(request.getAmount());
        expense.setDate(request.getDate());
        expense.setCategory(category);

        return expenseRepository.save(expense);
    }

    public List<Expense> getMonthlyExpenses(int year, int month) {

        LocalDate start = LocalDate.of(year, month, 1);
        LocalDate end = start.withDayOfMonth(start.lengthOfMonth());

        return expenseRepository.findByDateBetween(start, end);
    }

    public Double getTotalExpense() {
        return expenseRepository.findAll()
                .stream()
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    public List<Expense> getByCategory(String name) {
        return expenseRepository.findByCategory_Name(name);
    }

    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }
}
