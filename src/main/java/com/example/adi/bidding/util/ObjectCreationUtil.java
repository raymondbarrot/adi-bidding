package com.example.adi.bidding.util;

import com.example.adi.bidding.constants.BidStatus;
import com.example.adi.bidding.entity.BidOffer;
import com.example.adi.bidding.model.BidRequest;

public class ObjectCreationUtil {
    private static ObjectCreationUtil instance;

    public static ObjectCreationUtil getInstance(){
        if(instance == null){
            instance = new ObjectCreationUtil();
        }
        return instance;
    }

    public BidOffer createInventoryItem(BidRequest request){
        return BidOffer.builder()
                .bidId(request.getBidId())
                .amount(request.getAmount())
                .numberOfResources(request.getNumberOfResources())
                .status(BidStatus.valueOf(request.getStatus()))
                .itemCode(request.getItemCode())
                .build();
    }
}
