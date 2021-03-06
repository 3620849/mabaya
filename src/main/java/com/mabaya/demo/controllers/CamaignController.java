package com.mabaya.demo.controllers;

import com.mabaya.demo.model.Campaign;
import com.mabaya.demo.model.CampaignRequest;
import com.mabaya.demo.services.CampaignService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CamaignController {
    @Autowired
    CampaignService campaignService;
    @RequestMapping(value = "/campaign", method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<Campaign> createCampaign(@RequestBody CampaignRequest campaign){
        Campaign c=null;
        try{
            c = campaignService.createCampaign(campaign);
        }
        catch (IllegalArgumentException e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        };
        return new ResponseEntity(c, HttpStatus.OK);
    }
}
