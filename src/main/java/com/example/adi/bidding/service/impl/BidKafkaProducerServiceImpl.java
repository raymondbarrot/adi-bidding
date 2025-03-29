package com.example.adi.bidding.service.impl;

import com.example.adi.bidding.config.ConstantsConfig;
import com.example.adi.bidding.model.BidRequest;
import com.example.adi.bidding.service.BidKafkaProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BidKafkaProducerServiceImpl implements BidKafkaProducerService {
    @Autowired
    private ConstantsConfig constantsConfig;
    @Autowired
    private KafkaTemplate<String, BidRequest> kafkaTemplate;
    @Override
    public void publish(BidRequest bidRequest) {
        log.info("Produced: {}", bidRequest);
        this.kafkaTemplate.send(constantsConfig.getInventoryTopic(), bidRequest);
    }
}
