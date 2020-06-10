package com.mabaya.demo.controllers;

import com.mabaya.demo.model.Product;
import com.mabaya.demo.services.ServeAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ServeAdController {
    @Autowired
    ServeAdService serveAdService;
    @RequestMapping(value = "/serveAd/{category}", method = RequestMethod.GET)
    ResponseEntity<Product> serveAd(@PathVariable("category") String category){
        return new ResponseEntity<>( serveAdService.getProduct(category), HttpStatus.OK);
    }
}
