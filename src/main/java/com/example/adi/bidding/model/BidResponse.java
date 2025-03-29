package com.example.adi.bidding.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class BidResponse {
    private String status;
    private String reason;
}
