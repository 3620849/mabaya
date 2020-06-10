# mabaya interviw test

this is springboot application to run application navigate to main class DemoApplication.java

**Please pay ATTENTION i have used embedded MongoDb to save products first run can take ~1 minute till embeded mongodb will be downloaded**

You can navigate to package com.mabaya.demo.services/ProductService.java to see list all products;

## Api

## [PUT] localhost:8080/api/campaign

**to add new campaign**

**consumes: content-type:application-json**

**body:**

{

	"name":"MyCampaign",
  
	"bid": 60,
  
	"sellerId":"XX"
  
}

**proudces:**

{

    "id": "5ee0cff899b9a630331f75c3",
    
    "name": "MyCampaign",
    
    "bid": 60,
    
    "sellerId": "XX",
    
    "state": "ACTIVE",
    
    "products": [
    
        {
        
            "serialNumber": "5ee0cfc999b9a630331f75b7",
            
            "title": "Playstation5",
            
            "price": 1000,
            
            "category": "XX",
            
            "sellerId": "XX"
            
        }
    ]
}

## [GET] localhost:8080/api/serveAd/{category}

**to get product**

**produces single product**

{
    "serialNumber": "5ee0cfc999b9a630331f75b8",
    
    "title": "Playstation5",
    
    "price": 1200,
    
    "category": "XX",
    
    "sellerId": "XX"
}
