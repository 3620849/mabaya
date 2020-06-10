package com.mabaya.demo.services;

import com.mabaya.demo.model.Product;
import com.mabaya.demo.repositories.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServeAdService {
    @Autowired
    CampaignRepository campaignRepository;
    public Product getProduct(String category) {
        return campaignRepository.getProductForAd(category);
    }
}
