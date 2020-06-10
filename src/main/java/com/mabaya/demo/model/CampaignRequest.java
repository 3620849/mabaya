package com.mabaya.demo.model;

import lombok.Data;

@Data
public class CampaignRequest {
    private String name;
    private long bid;
    private String sellerId;
}
