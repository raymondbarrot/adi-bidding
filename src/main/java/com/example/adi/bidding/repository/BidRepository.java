package com.example.adi.bidding.repository;

import com.example.adi.bidding.entity.BidOffer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BidRepository extends JpaRepository<BidOffer, String> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE bid_offer SET amount=:amount, number_of_resources=:numberOfResources, " +
            "status=:status, item_code=:itemCode WHERE bid_id=:bidId", nativeQuery = true)
    void updateInventoryItem(@Param("amount") Double amount,
                             @Param("numberOfResources") Integer numberOfResources,
                             @Param("status") String status,
                             @Param("itemCode") String itemCode,
                             @Param("bidId") String bidId);
}
