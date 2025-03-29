package com.example.adi.bidding.entity;

import com.example.adi.bidding.constants.BidStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class BidOffer {
    @Id
    private String bidId;
    private Double amount;
    private Integer numberOfResources;

    @Enumerated(EnumType.STRING)
	private BidStatus status;

	private String itemCode;
}
