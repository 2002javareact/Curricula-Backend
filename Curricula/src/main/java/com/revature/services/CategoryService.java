package com.revature.services;

import com.revature.models.Category;
import java.util.List;

public interface CategoryService {
    public List<Category> getAllCategories();
    public Category saveNewCategory(Category c);
    // public Category getCategoryById(int id);
    public Category updateCategory(Category c);
    public Category deleteCategory(int id);
}