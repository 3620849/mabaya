package com.mabaya.demo.repositories;

import com.mabaya.demo.model.Product;

public interface SearchEngine {
    Product getProductForAd(String category);
}
