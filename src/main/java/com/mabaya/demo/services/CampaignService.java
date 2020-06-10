package com.mabaya.demo.services;

import com.mabaya.demo.model.Campaign;
import com.mabaya.demo.model.CampaignRequest;
import com.mabaya.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampaignService {

    @Autowired
    ProductRepository productRepository;

    public Campaign createCampaign(CampaignRequest request){
        //search all products and add in campaign

        return new Campaign();
    };
}
