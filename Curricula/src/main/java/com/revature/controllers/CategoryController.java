package com.revature.controllers;

import java.util.List;

import com.revature.models.Category;
import com.revature.services.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("category")
public class CategoryController {
    private CategoryService cs;

    @Autowired
    public CategoryController(CategoryService cs) {
        this.cs = cs;
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategory() {
        return new ResponseEntity(cs.getAllCategories(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Category> saveNewCategory(Category c) {
        if (c.getCategoryId() != 0) {
            return new ResponseEntity("Id must be 0", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(cs.saveNewCategory(c), HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<Category> updateCategory(@RequestBody Category c) {
        if (c.getCategoryId() == 0) {
            return new ResponseEntity("Category id must not be 0", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(cs.updateCategory(c), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable int id) {
        if (id == 0) {
            return new ResponseEntity("Category id must not be 0", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(cs.deleteCategory(id), HttpStatus.CREATED);
    }

    // @GetMapping("{id}")
    // public ResponseEntity<Category> getCategoryById(@PathVariable int id){
    // if(id == 0){
    // return new ResponseEntity("Category id must not be 0",
    // HttpStatus.BAD_REQUEST);
    // }
    // return new ResponseEntity(cs.getCategoryById(id), HttpStatus.CREATED)
    // }

}