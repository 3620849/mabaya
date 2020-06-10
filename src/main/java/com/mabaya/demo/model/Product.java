package com.mabaya.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    @Id
    private String serialNumber;
    private String title;
    private long price;
    private String category;
    private String sellerId;

}
