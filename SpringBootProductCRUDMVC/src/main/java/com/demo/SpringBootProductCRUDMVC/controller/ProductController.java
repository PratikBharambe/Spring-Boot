package com.demo.SpringBootProductCRUDMVC.controller;

import java.net.http.HttpResponse;
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

import com.demo.SpringBootProductCRUDMVC.beans.Product;
import com.demo.SpringBootProductCRUDMVC.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> plist = productService.getAllProducts();
		if(plist != null)
			return ResponseEntity.ok(plist);
		else
			return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id) {
		Optional<Product> p = productService.getBYId(id);
		if(p != null)
			return ResponseEntity.ok(p.get());
		else
			return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/products/{id}")
	public String addNewProduct(@RequestBody Product p) {
		boolean status = productService.addNewProduct(p);
		if(status)
			return "Product added successfully.";
		else
			return "Error in product insertion.";
	}
	
	@PutMapping("/products/{id}")
	public String updateProduct(@RequestBody Product p) {
		boolean status = productService.updateProduct(p);
		if(status)
			return "Product Update successfully.";
		else
			return "Error in product updation.";
	}
	
	@DeleteMapping("/products/{id}")
	public String deleteProduct(@PathVariable int id) {
		boolean status = productService.deleteProduct(id);
		if(status)
			return "Product deleted successfully.";
		else
			return "Error in product deletion.";
	}
}
