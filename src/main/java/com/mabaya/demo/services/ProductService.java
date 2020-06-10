package com.mabaya.demo.services;

import com.mabaya.demo.model.Product;
import com.mabaya.demo.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    @Autowired
    ProductRepository repository;
    @EventListener(ApplicationReadyEvent.class)
    public void addDataInDb(){
        List<Product> products = Arrays.asList(
                Product.builder().category("XX").price(1000).sellerId("XX").title("Playstation5").build(),
                Product.builder().category("XX").price(1200).sellerId("XX").title("Playstation5").build(),
                Product.builder().category("XY").price(8000).sellerId("XX").title("Playstation5").build()
        );
        repository.insert(products);
        LOGGER.info("was added "+ repository.count() +" products");
    }
}
