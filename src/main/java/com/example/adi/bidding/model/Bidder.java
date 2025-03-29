package com.example.adi.bidding.model;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Slf4j
public class Bidder {
    private String bidderId;
    private String name;
    private String email;
    public void notifyBidder(BidRecommendation bidRecommendation){
        log.info("sending bid recommendation email to {}", name);
    }
}
