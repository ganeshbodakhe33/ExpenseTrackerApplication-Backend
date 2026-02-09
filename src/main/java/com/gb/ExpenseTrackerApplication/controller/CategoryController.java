package com.gb.ExpenseTrackerApplication.controller;

import com.gb.ExpenseTrackerApplication.model.Category;
import com.gb.ExpenseTrackerApplication.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public Category add(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    @GetMapping
    public List<Category> all() {
        return categoryService.getAllCategories();
    }
}

