package com.joragar.springbootwebappsecuritytemplate.loader;

import com.joragar.springbootwebappsecuritytemplate.domain.Product;
import com.joragar.springbootwebappsecuritytemplate.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.logging.Logger;

@Component
public class ProductLoader implements ApplicationListener<ContextRefreshedEvent>{

    private ProductRepository productRepository;

    private Logger log = Logger.getLogger("ProductLoader.class");

    @Autowired
    public void setProductRepository(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event){

        Product shirt = new Product();
        shirt.setDescription("Jorgar Shirt");
        shirt.setPrice(new BigDecimal("18.95"));
        shirt.setImageUrl("http://www.google.es");
        shirt.setProductId("23145678973464");
        productRepository.save(shirt);

        log.info("Saved Shirt - id: " + shirt.getId());

        Product mug = new Product();
        mug.setDescription("Joragar Mug");
        mug.setPrice(new BigDecimal("9.95"));
        mug.setImageUrl("http://www.google.es");
        mug.setProductId("4645461231231654");
        productRepository.save(mug);

        log.info("Saved Mug - id: " + mug.getId());
    }


}
