package com.joragar.springbootwebappsecuritytemplate.repositories;

import com.joragar.springbootwebappsecuritytemplate.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer>{
}
