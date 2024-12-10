package com.demo.MySpringBootCRUDProductMVC.controller;

import java.io.ObjectInputFilter.Status;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.MySpringBootCRUDProductMVC.beans.Product;
import com.demo.MySpringBootCRUDProductMVC.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService pservice ;
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> plist = pservice.getAllProducts();
		if(plist != null) {
			return ResponseEntity.ok(plist);
		}else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getById(@PathVariable int id){
		Optional<Product> p=pservice.getById(id);
		
		if(p!=null) {
			return ResponseEntity.ok(p.get());
		}else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/products/{id}")
	public String addNewProduct(@RequestBody Product p) {
		boolean  status = pservice.addNewProduct(p);
		if(status)
			return "Product added successfully.";
		else
			return "Error in product insertion.";
	} 
	
	@PutMapping("/products/{id}")
	public String updateProduct(@RequestBody Product p) {
		boolean  status = pservice.updateProduct(p);
		if(status)
			return "Product Updated successfully.";
		else
			return "Error in product Updation.";
	} 
	
	@DeleteMapping("/products/{id}")
	public String deleteProduct(@PathVariable int id) {
		boolean  status = pservice.deleteProduct(id);
		if(status)
			return "Product Deleted successfully.";
		else
			return "Error in product Delection.";
	} 

}
