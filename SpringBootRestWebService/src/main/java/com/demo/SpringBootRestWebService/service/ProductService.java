package com.demo.SpringBootRestWebService.service;

import com.demo.SpringBootRestWebService.beans.Product;
import com.demo.SpringBootRestWebService.dto.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> getAllProducts();

    ProductDto getBYId(int id);

    boolean addNewProduct(ProductDto pdto);

    boolean updateProduct(ProductDto pdto);

    boolean deleteProduct(int id);

    List<ProductDto> findByCategory(int cid) ;

}
