package com.demo.SpringBootProductCRUDMVC.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.SpringBootProductCRUDMVC.beans.Product;
import com.demo.SpringBootProductCRUDMVC.dao.ProductDao;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;

	@Override
	public List<Product> getAllProducts() {
		return productDao.findAll();
	}

	@Override
	public Optional<Product> getBYId(int id) {
		return productDao.findById(id);
	}

	@Override
	public boolean addNewProduct(Product p) {
		Product p1 = productDao.save(p);
		if(p1 != null)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateProduct(Product p) {
		Optional<Product> op =  productDao.findById(p.getId());
		if(op != null) {
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
	
}
