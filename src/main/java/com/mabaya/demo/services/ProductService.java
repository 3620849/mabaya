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
                Product.builder().category("XY").price(8000).sellerId("XX").title("Playstation5").build(),
                Product.builder().category("C").price(222).sellerId("A1").title("PCUltimate").build(),
                Product.builder().category("C").price(333).sellerId("A1").title("PCGamer").build(),
                Product.builder().category("Y").price(444).sellerId("A1").title("PCWork").build(),
                Product.builder().category("C").price(5000).sellerId("A2").title("LaptopUltra").build(),
                Product.builder().category("C").price(6000).sellerId("A2").title("LaptopGame").build(),
                Product.builder().category("Y").price(2000).sellerId("A2").title("LaptopWork").build(),
                Product.builder().category("C").price(50).sellerId("A3").title("LaptopLenovo").build(),
                Product.builder().category("C").price(70).sellerId("A3").title("LaptopLenovo1").build(),
                Product.builder().category("O").price(70).sellerId("A3").title("LaptopLenovo2").build()
        );
        repository.insert(products);
        LOGGER.info("was added "+ repository.count() +" products");
    }
}
