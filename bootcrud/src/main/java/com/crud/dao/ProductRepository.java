package com.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
