package com.mabaya.demo.repositories;

import com.mabaya.demo.model.Campaign;
import com.mabaya.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;

import java.util.List;

public class SearchEngineImpl implements SearchEngine {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Product getProductForAd(String category) {
        MatchOperation matchCampState = Aggregation.match(Criteria.where("state").is("ACTIVE"));
        Aggregation maxBidAndCat = Aggregation.newAggregation(matchCampState );
        AggregationResults<Campaign> aggregate = mongoTemplate.aggregate(maxBidAndCat,"campaign", Campaign.class);
        List<Campaign> listCamp = aggregate.getMappedResults();
        Campaign campaign = listCamp.get(0);
        Product product = campaign.getProducts().get(0);
        return product;
    }
}
