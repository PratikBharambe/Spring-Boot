package com.demo.SpringBootProductCRUDMVC.dao;

import com.demo.SpringBootProductCRUDMVC.beans.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDao extends JpaRepository<Category, Integer> {
}
