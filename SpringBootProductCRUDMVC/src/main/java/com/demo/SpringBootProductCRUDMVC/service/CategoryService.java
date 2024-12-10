package com.demo.SpringBootProductCRUDMVC.service;

import com.demo.SpringBootProductCRUDMVC.beans.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getAllCategories();

    Optional<Category> getById(int id);

    boolean addNewCategory(Category c);

    boolean updateCategory(Category c);

    boolean deleteCategory(int id);
}
