package com.demo.SpringBootProductCRUDMVC.service;

import com.demo.SpringBootProductCRUDMVC.beans.Category;
import com.demo.SpringBootProductCRUDMVC.dao.CategoryDao;
import com.demo.SpringBootProductCRUDMVC.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryDao categoryDao;

    @Override
    public List<Category> getAllCategories() {
        return  categoryDao.findAll();
    }

    @Override
    public Optional<Category> getById(int id) {
        return categoryDao.findById(id);
    }

    @Override
    public boolean addNewCategory(Category c) {
        Category c1 = categoryDao.save(c);
        return true;
    }

    @Override
    public boolean updateCategory(Category c) {
        Optional<Category> op = categoryDao.findById(c.getId());
        if (op.isPresent()){
            Category c1 = op.get();
            c1.setCname(c.getCname());
            c1.setCdesc(c.getCdesc());
            categoryDao.save(c1);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCategory(int id) {
        try {
            categoryDao.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
