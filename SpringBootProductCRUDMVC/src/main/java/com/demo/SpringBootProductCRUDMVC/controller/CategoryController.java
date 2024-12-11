package com.demo.SpringBootProductCRUDMVC.controller;

import com.demo.SpringBootProductCRUDMVC.beans.Category;
import com.demo.SpringBootProductCRUDMVC.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "http://localhost:5173")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> clist = categoryService.getAllCategories();
        if (clist != null)
            return  ResponseEntity.ok(clist);
        else
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<Category> getById(@PathVariable int id) {
        Optional<Category> c = categoryService.getById(id);
        if (c != null)
            return  ResponseEntity.ok(c.get());
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/categories/{id}")
    public String addNewCategory(@RequestBody Category c) {
        boolean status = categoryService.addNewCategory(c);
        if(status)
            return "Category added successfully.";
        else
            return "Error in Category insertion.";
    }

    @PutMapping("/categories/{id}")
    public String UpdateCategory(@RequestBody Category c) {
        boolean status = categoryService.updateCategory(c);
        if(status)
            return "Category updated successfully.";
        else
            return "Error in Category update.";
    }

    @DeleteMapping("/categories/{id}")
    public String deleteCategory(@PathVariable int id) {
        boolean status = categoryService.deleteCategory(id);
        if(status)
            return "Category deleted successfully.";
        else
            return "Error in Category deletion.";
    }
}
