package com.demo.SpringBootRestWebService.mapper;

import com.demo.SpringBootRestWebService.beans.Product;
import com.demo.SpringBootRestWebService.dto.ProductDto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProductDtoMapper {

    public static ProductDto mapToProductDto(Product p){
        return new ProductDto(p.getId(), p.getName(), p.getQty(), p.getPrice(), p.getExpdate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), p.getCid());
    }

    public static Product mapToProduct(ProductDto p){
        return new Product(p.getId(), p.getName(),p.getQty(), p.getPrice(), LocalDate.parse(p.getExpdate(), DateTimeFormatter.ofPattern("dd/MM/yyyy")), p.getCid());
    }
}
