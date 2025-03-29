package com.example.adi.bidding.service.impl;

import com.example.adi.bidding.model.BidRecommendation;
import com.example.adi.bidding.service.BidKafkaConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BidKafkaConsumerServiceImpl implements BidKafkaConsumerService {
    @Override
    @KafkaListener(topics = "${kafka.topic.bidding}", groupId = "bidding-group")
    public void consumeMessage(BidRecommendation bidRecommendation) {
        log.info("Consumed: {}", bidRecommendation);
    }
}
