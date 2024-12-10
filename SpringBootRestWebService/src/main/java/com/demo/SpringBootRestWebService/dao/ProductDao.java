package com.demo.SpringBootRestWebService.dao;

import com.demo.SpringBootRestWebService.beans.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {

    @Query(value = "select * from product where cid = :cid", nativeQuery = true)
    List<Product> getProductsByCid(int cid);
}
