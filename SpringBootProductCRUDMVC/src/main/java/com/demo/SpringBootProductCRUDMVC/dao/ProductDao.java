package com.demo.SpringBootProductCRUDMVC.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.SpringBootProductCRUDMVC.beans.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {

}
