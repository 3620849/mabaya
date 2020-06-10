package com.mabaya.demo.services;

import com.mabaya.demo.model.Campaign;
import com.mabaya.demo.model.CampaignRequest;
import com.mabaya.demo.model.CampaignState;
import com.mabaya.demo.model.Product;
import com.mabaya.demo.repositories.CampaignRepository;
import com.mabaya.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignService {

    @Autowired
    CampaignRepository campaignRepository;
    @Autowired
    ProductRepository productRepository;
    public Campaign createCampaign(CampaignRequest request){
        //search all products and add in campaign
        List<Product> products = productRepository.findBySellerId(request.getSellerId());
        Campaign campaign = Campaign.builder().state(CampaignState.ACTIVE).bid(request.getBid()).name(request.getName())
                .sellerId(request.getSellerId()).products(products).build();
        campaignRepository.insert(campaign);
        return campaign;
    };
}
