package com.gb.ExpenseTrackerApplication.repository;

import com.gb.ExpenseTrackerApplication.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
//    What Spring gives you automatically:
        //
        //save()
        //
        //findAll()
        //
        //findById()
        //
        //delete()
}
