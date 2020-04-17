package com.revature.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Category;

/**
 * The interface Category dao.
 */
@Repository
public interface CategoryDao extends JpaRepository<Category, Integer> {

}