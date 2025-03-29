package com.example.adi.bidding.service.impl;

import com.example.adi.bidding.model.BidRecommendation;
import com.example.adi.bidding.model.Bidder;
import com.example.adi.bidding.repository.BidderRepository;
import com.example.adi.bidding.service.BidKafkaConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BidKafkaConsumerServiceImpl implements BidKafkaConsumerService {
    @Override
    @KafkaListener(topics = "${kafka.topic.bidding}", groupId = "bidding-group")
    public void consumeMessage(BidRecommendation bidRecommendation) {
        log.info("Consumed: {}", bidRecommendation);
        notifyBidders(bidRecommendation);
    }

    private void notifyBidders(BidRecommendation bidRecommendation){
        List<Bidder> bidders = BidderRepository.getInstance().getBidders();
        for(Bidder bidder: bidders){
            bidder.notifyBidder(bidRecommendation);
        }
    }
}
