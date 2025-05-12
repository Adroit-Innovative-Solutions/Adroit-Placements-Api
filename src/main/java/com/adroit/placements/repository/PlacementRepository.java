package com.adroit.placements.repository;

import com.adroit.placements.model.PlacementDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlacementRepository extends JpaRepository<PlacementDetails, String> {

    // Custom query methods (optional)
    List<PlacementDetails> findByConsultantName(String consultantName);
    List<PlacementDetails> findByClientName(String clientName);
    List<PlacementDetails> findByVendorName(String vendorName);
}




