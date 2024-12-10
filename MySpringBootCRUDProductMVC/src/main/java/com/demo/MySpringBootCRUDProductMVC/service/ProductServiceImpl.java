package com.demo.MySpringBootCRUDProductMVC.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.MySpringBootCRUDProductMVC.beans.Product;
import com.demo.MySpringBootCRUDProductMVC.dao.ProductDao;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDao pdao;

	@Override
	public List<Product> getAllProducts() {
		return pdao.findAll();
	}

	@Override
	public Optional<Product> getById(int id) {
		
		return pdao.findById(id);
	}

	@Override
	public boolean addNewProduct(Product p) {
		Product p1 = pdao.save(p);
		return !(p1 == null);
	}

	@Override
	public boolean updateProduct(Product p) {
		Optional<Product> op= pdao.findById(p.getId());
		if(op != null) {
		Product p1 = op.get();
		p1.setName(p.getName());
		p1.setQty(p.getQty());
		p1.setPrice(p.getPrice());
		p1.setCid(p.getCid());
		
		pdao.save(p1);
		
		return true;
		}
		return false;
		
	}

	@Override
	public boolean deleteProduct(int id) {
		try {
			pdao.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	

}
