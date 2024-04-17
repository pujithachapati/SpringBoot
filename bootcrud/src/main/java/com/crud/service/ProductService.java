package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.crud.dao.ProductRepository;
import com.crud.model.Product;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productrepo;
	
	public List<Product> getAllProducts(){
		return productrepo.findAll();
	}
	
	public Product createOrUpdateProduct(Product product) {
        return productrepo.save(product);
    }
	
	public Product getProductById(Integer id) {
		return productrepo.findById(id).orElse(null);
	}
	public Product updateProduct(Product updateproduct,Integer id) {
		Product product = productrepo.findById(id).orElse(null);
		if(product!=null) {
			product.setProductname(updateproduct.getProductname());
			product.setProductusage(updateproduct.getProductusage());
			product.setPrice(updateproduct.getPrice());
		}
		
		return productrepo.save(product);
	}
	public boolean deleteproduct(Integer id) {
		productrepo.deleteById(id);
		return true;
	}
}
