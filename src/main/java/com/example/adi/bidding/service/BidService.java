package com.example.adi.bidding.service;

import com.example.adi.bidding.model.BidRequest;
import com.example.adi.bidding.model.BidResponse;

public interface BidService {
    public BidResponse addBid(BidRequest request);
    public BidResponse updateBid(BidRequest request);
}
