package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.model.Product;
import com.crud.service.ProductService;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {
    
    @Autowired
    private ProductService productservice;
    
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productservice.getAllProducts();
    }
    
    @PostMapping("/products")
    public ResponseEntity<Product> createOrUpdateProduct(@RequestBody Product product) {
        Product savedProduct = productservice.createOrUpdateProduct(product);

        if (savedProduct != null) {
            return ResponseEntity.ok(savedProduct);
        } else {
            return ResponseEntity.status(null).build();
        }
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        Product product = productservice.getProductById(id);
        return ResponseEntity.ok(product);
    }
    @DeleteMapping("/products/{id}")
    public ResponseEntity<Product> deleteproduct(@PathVariable Integer id){
    	Product product = productservice.getProductById(id);
    	boolean deleted=productservice.deleteproduct(id);
    	if(deleted) {
    		return ResponseEntity.ok(product);
    	}else {
    		return null;
    	}
    }
    @PutMapping("/products/{id}")
    public ResponseEntity<Product> update(@PathVariable Integer id,@RequestBody Product product){
    	Product updateproduct=productservice.updateProduct(product, id);
    	return ResponseEntity.ok(updateproduct);
    }
}
