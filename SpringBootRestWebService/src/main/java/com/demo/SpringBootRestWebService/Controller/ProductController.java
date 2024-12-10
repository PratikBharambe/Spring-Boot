package com.demo.SpringBootRestWebService.Controller;

import com.demo.SpringBootRestWebService.dto.ProductDto;
import com.demo.SpringBootRestWebService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        List<ProductDto> plist=productService.getAllProducts();
        return ResponseEntity.ok(plist);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable int id){
        ProductDto p=productService.getBYId(id);
        if(p!=null)
            return ResponseEntity.ok(p);
        else
            return ResponseEntity.status(500).body(null);
    }
    @GetMapping("/category/products/{cid}")
    public ResponseEntity<List<ProductDto>> getByCategory(@PathVariable int cid){
        List<ProductDto> plist=productService.findByCategory(cid);
        return ResponseEntity.ok(plist);
    }

    @PostMapping("/products/{id}")
    public ResponseEntity<String> addProduct(@RequestBody ProductDto p){
        boolean status=productService.addNewProduct(p);
        if(status) {
            return ResponseEntity.ok("Data added successfully");
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/products/{id}")
    public ResponseEntity<String> updateProduct(@RequestBody ProductDto p){
        boolean status=productService.updateProduct(p);
        if(status) {
            return ResponseEntity.ok("Data updated successfully");
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        boolean status=productService.deleteProduct(id);
        if(status) {
            return ResponseEntity.ok("Data deleted successfully");
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
