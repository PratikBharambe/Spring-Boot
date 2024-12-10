package com.demo.SpringBootProductCRUDMVC.service;

import java.util.List;
import java.util.Optional;

import com.demo.SpringBootProductCRUDMVC.beans.Product;

public interface ProductService {

	List<Product> getAllProducts();

	Optional<Product> getBYId(int id);

	boolean addNewProduct(Product p);

	boolean updateProduct(Product p);

	boolean deleteProduct(int id);

}
