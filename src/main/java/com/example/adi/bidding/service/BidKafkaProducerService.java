package com.example.adi.bidding.service;

import com.example.adi.bidding.model.BidRequest;

public interface BidKafkaProducerService {
    public void publish(BidRequest inventoryRequest);
}
