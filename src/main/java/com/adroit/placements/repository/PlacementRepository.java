package com.adroit.placements.repository;

import com.adroit.placements.model.PlacementDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlacementRepository extends JpaRepository<PlacementDetails, Long> {

    // Custom query methods (optional)
    List<PlacementDetails> findByConsultantName(String consultantName);
    List<PlacementDetails> findByClient(String client);
    List<PlacementDetails> findByVendor(String vendor);
}




