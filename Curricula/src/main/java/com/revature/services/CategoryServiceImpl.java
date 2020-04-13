package com.revature.services;

import java.util.List;

import com.revature.daos.CategoryDao;
import com.revature.models.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryDao cd;

    @Autowired
    public CategoryServiceImpl(CategoryDao cd) {
        this.cd = cd;
    }

    @Override
    public List<Category> getAllCategories() {
        return cd.findAll();
    }

    /**
     * Sort method:Dzimtry
     * 
     * @Override public List<Users> getAllUsers() { return
     *           ud.findAll(Sort.by(Sort.Direction.ASC, "userId")); //Sorted By
     *           userId asc }
     * 
     */
    @Override
    public Category saveNewCategory(Category c) {
        return cd.save(c);
    }

    // @Override
    // public Category getCategoryById(int id){
    // return cd.getOne(id);
    // }

    @Override
    @Transactional
    public Category updateCategory(Category c) {
        Category oldC = cd.getOne(c.getCategoryId());
        if (c.getCategoryColor() != null) {
            oldC.setCategoryColor(c.getCategoryColor());
        }
        if (c.getCategoryName() != null) {
            oldC.setCategoryName(c.getCategoryName());
        }
        return oldC;
    }

    @Override
    public Category deleteCategory(int id) {
        Category oldC = cd.getOne(id);
        cd.deleteById(id);
        return oldC;
    }

}