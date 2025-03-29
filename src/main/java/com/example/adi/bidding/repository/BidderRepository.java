package com.example.adi.bidding.repository;

import com.example.adi.bidding.model.Bidder;

import java.util.ArrayList;
import java.util.List;

public class BidderRepository {
    private static List<Bidder> bidders = new ArrayList<>();
    private static BidderRepository instance;

    public static BidderRepository getInstance() {
        if(instance == null) {
            instance = new BidderRepository();
            initializeBidders();
        }
        return instance;
    }

    private static void initializeBidders(){
        Bidder bidderJohn = Bidder.builder()
                .bidderId("bid01")
                .name("John")
                .email("john@beatles.com")
                .build();

        Bidder bidderPaul = Bidder.builder()
                .bidderId("bid02")
                .name("Paul")
                .email("paul@beatles.com")
                .build();

        Bidder bidderGeorge = Bidder.builder()
                .bidderId("bid03")
                .name("George")
                .email("george@beatles.com")
                .build();

        Bidder bidderRingo = Bidder.builder()
                .bidderId("bid04")
                .name("Ringo")
                .email("ringo@beatles.com")
                .build();

        bidders.add(bidderJohn);
        bidders.add(bidderPaul);
        bidders.add(bidderGeorge);
        bidders.add(bidderRingo);
    }

    public List<Bidder> getBidders() {
        return bidders;
    }
}
