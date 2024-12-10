package com.demo.MySpringBootCRUDProductMVC.service;

import java.util.List;
import java.util.Optional;

import com.demo.MySpringBootCRUDProductMVC.beans.Product;

public interface ProductService {

	List<Product> getAllProducts();

	Optional<Product> getById(int id);

	boolean addNewProduct(Product p);

	boolean updateProduct(Product p);

	boolean deleteProduct(int id);

}
