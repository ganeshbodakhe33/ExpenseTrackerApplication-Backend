package com.gb.ExpenseTrackerApplication.service;

import com.gb.ExpenseTrackerApplication.model.Category;
import com.gb.ExpenseTrackerApplication.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

//    Why Service?
    //
    //Keeps logic out of Controller
    //
    //Reusable logic
}
