package com.mabaya.demo.repositories;

import com.mabaya.demo.model.Campaign;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CampaignRepository extends MongoRepository<Campaign,String>,SearchEngine {
}
