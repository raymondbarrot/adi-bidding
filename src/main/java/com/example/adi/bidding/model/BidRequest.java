package com.example.adi.bidding.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class BidRequest {
    private String bidId;
    private Double amount;
    private Integer numberOfResources;
    private String status;
    private String itemCode;
}
