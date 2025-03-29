package com.example.adi.bidding.controller;

import com.example.adi.bidding.model.BidRequest;
import com.example.adi.bidding.model.BidResponse;
import com.example.adi.bidding.service.BidService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/bidding")
public class BidController {
    private final BidService bidService;

    public BidController(BidService bidService) {
        this.bidService = bidService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<BidResponse> addBid(@RequestBody BidRequest request){
        return new ResponseEntity<>(bidService.addBid(request), HttpStatus.OK);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<BidResponse> updateBid(@RequestBody BidRequest request){
        return new ResponseEntity<>(bidService.updateBid(request), HttpStatus.OK);
    }

}
