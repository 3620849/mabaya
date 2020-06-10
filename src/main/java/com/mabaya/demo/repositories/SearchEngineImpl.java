package com.mabaya.demo.repositories;

import com.mabaya.demo.model.Campaign;
import com.mabaya.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.query.Criteria;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort;

public class SearchEngineImpl implements SearchEngine {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Product getProductForAd(String category) {
        MatchOperation matchCampState = Aggregation.match(Criteria.where("state").is("ACTIVE"));
        MatchOperation matchCategory = Aggregation.match(Criteria.where("products.category").is(category));
        SortOperation bidSort = sort(Sort.Direction.DESC, "bid");
        Aggregation maxBidAndCat = Aggregation.newAggregation(matchCampState,bidSort,matchCategory);
        AggregationResults<Campaign> aggregate = mongoTemplate.aggregate(maxBidAndCat,"campaign", Campaign.class);
        List<Campaign> listCamp = aggregate.getMappedResults();
        //if no found reduce conditions and search without category
        boolean withCategory = true;
        if(listCamp.size()==0){
            Aggregation maxBidAg = newAggregation(matchCampState, bidSort);
            aggregate = mongoTemplate.aggregate(maxBidAg, "campaign", Campaign.class);
            listCamp = aggregate.getMappedResults();
            withCategory=false;
        }
        //get camp with max bid
        long maxBid = listCamp.get(0).getBid();
        listCamp = listCamp.stream().filter(campaign ->campaign.getBid()==maxBid).collect(Collectors.toList());
        Product product = null;
        if(listCamp.size()>1){
            //get random campaign
            if(withCategory){
                //filter for category
            }
            //get random product
        }else if(listCamp.size()==1){
            //get 0 campaign
            if(withCategory){
                //filter for category
            }
            //get random product
        }
        return product;
    }
}
