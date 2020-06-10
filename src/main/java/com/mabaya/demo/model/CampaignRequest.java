package com.mabaya.demo.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class CampaignRequest {
    @NonNull
    private String name;
    @NonNull
    private long bid;
    @NonNull()
    private String sellerId;
}
