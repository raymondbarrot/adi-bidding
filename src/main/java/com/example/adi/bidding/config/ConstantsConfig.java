package com.example.adi.bidding.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
public class ConstantsConfig {
    @Value("${kafka.topic.bidding}")
    private String biddingTopic;

    @Value("${kafka.topic.inventory}")
    private String inventoryTopic;

    @Value("${kafka.bootstrap.server}")
    private String kafkaServer;
}
