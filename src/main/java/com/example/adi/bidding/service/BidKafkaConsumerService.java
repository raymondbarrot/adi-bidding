package com.example.adi.bidding.service;

import com.example.adi.bidding.model.BidRecommendation;

public interface BidKafkaConsumerService {
    public void consumeMessage(BidRecommendation bidRecommendation);
}
