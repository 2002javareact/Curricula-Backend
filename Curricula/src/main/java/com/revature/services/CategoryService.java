package com.revature.services;

import com.revature.models.Category;
import java.util.List;

/**
 * The interface Category service.
 */
public interface CategoryService {
    /**
     * Gets all categories.
     *
     * @return the all categories
     */
    public List<Category> getAllCategories();

    /**
     * Save new category category.
     *
     * @param c the c
     * @return the category
     */
    public Category saveNewCategory(Category c);

    /**
     * Gets category.
     *
     * @param c the c
     * @return the category
     */
// public Category getCategoryById(int id);
    public Category updateCategory(Category c);

    /**
     * Delete category.
     *
     * @param id the id
     */
    public void deleteCategory(int id);
}