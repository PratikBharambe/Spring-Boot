package com.demo.SpringBootRestWebService.service;

import com.demo.SpringBootRestWebService.beans.Product;
import com.demo.SpringBootRestWebService.dao.ProductDao;
import com.demo.SpringBootRestWebService.dto.ProductDto;
import com.demo.SpringBootRestWebService.mapper.ProductDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements  ProductService{

    @Autowired
    ProductDao productDao;

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> plst = productDao.findAll();
        return plst.stream()
                .map(ProductDtoMapper::mapToProductDto)
                .toList();
    }

    @Override
    public ProductDto getBYId(int id) {
        Optional<Product> op = productDao.findById(id);
        return op.map(ProductDtoMapper::mapToProductDto).orElse(null);

    }

    @Override
    public boolean addNewProduct(ProductDto pdto) {
        Product p = ProductDtoMapper.mapToProduct(pdto);
        Product p1 = productDao.save(p);
        return true;
    }

    @Override
    public boolean updateProduct(ProductDto p) {
        Optional<Product> op =  productDao.findById(p.getId());
        if(op.isPresent()) {
            Product p1 = op.get();
            p1.setName(p.getName());
            p1.setQty(p.getQty());
            p1.setPrice(p.getPrice());
            p1.setCid(p.getCid());
            productDao.save(p1);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteProduct(int id) {
        try {
            productDao.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public List<ProductDto> findByCategory(int cid) {
        List<Product> plst =productDao.getProductsByCid(cid);
        return plst.stream()
                .map(ProductDtoMapper::mapToProductDto)
                .collect(Collectors.toList());
    }

}
