package com.example.adi.bidding.service.impl;

import com.example.adi.bidding.entity.BidOffer;
import com.example.adi.bidding.model.BidRequest;
import com.example.adi.bidding.model.BidResponse;
import com.example.adi.bidding.repository.BidRepository;
import com.example.adi.bidding.service.BidKafkaProducerService;
import com.example.adi.bidding.service.BidService;
import com.example.adi.bidding.util.ObjectCreationUtil;
import org.springframework.stereotype.Service;

@Service
public class BidServiceImpl implements BidService {
    private final BidKafkaProducerService bidKafkaProducerService;
    private final BidRepository bidRepository;

    public BidServiceImpl(BidKafkaProducerService bidKafkaProducerService, BidRepository bidRepository) {
        this.bidKafkaProducerService = bidKafkaProducerService;
        this.bidRepository = bidRepository;
    }

    @Override
    public BidResponse addBid(BidRequest request) {
        BidOffer bidOffer = ObjectCreationUtil.getInstance().createInventoryItem(request);
        bidRepository.save(bidOffer);
        bidKafkaProducerService.publish(request);
        return BidResponse.builder()
                .status("Success")
                .reason("Inventory item successfully updated.")
                .build();
    }

    @Override
    public BidResponse updateBid(BidRequest request) {
        bidRepository.updateInventoryItem(request.getAmount(), request.getNumberOfResources(),
                request.getStatus(), request.getItemCode(), request.getBidId());
        bidKafkaProducerService.publish(request);
        return BidResponse.builder()
                .status("Success")
                .reason("Inventory item successfully updated.")
                .build();
    }
}
