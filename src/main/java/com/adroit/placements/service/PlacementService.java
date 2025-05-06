package com.adroit.placements.service;

import com.adroit.placements.model.PlacementDetails;
import com.adroit.placements.repository.PlacementRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
public class PlacementService {

    @Autowired
    private PlacementRepository placementRepository;

    // Method to get all placements
    public List<PlacementDetails> getAllPlacements() {
        return placementRepository.findAll();
    }

    // Method to get a specific placement by ID
    public Optional<PlacementDetails> getPlacementById(Long id) {
        return placementRepository.findById(id);
    }

    // Method to add a new placement
    @Transactional
    public PlacementDetails addPlacement(PlacementDetails placementDetails) {
        // Ensure the entity is saved correctly
        PlacementDetails savedPlacement = placementRepository.save(placementDetails);
        // Log the saved placement details to confirm it's being stored correctly
        System.out.println("Placement saved with ID: " + savedPlacement.getId());
        return savedPlacement;
    }

    // Method to update an existing placement
    @Transactional
    public PlacementDetails updatePlacement(Long id, PlacementDetails placementDetails) {
        // Retrieve the existing placement from the database
        Optional<PlacementDetails> existingPlacement = placementRepository.findById(id);

        if (existingPlacement.isPresent()) {
            PlacementDetails updatedPlacement = existingPlacement.get();

            // Update the fields that need to be updated (modify only necessary fields)
            updatedPlacement.setConsultantName(placementDetails.getConsultantName());
            updatedPlacement.setMailId(placementDetails.getMailId());
            updatedPlacement.setDomain(placementDetails.getDomain());
            updatedPlacement.setClient(placementDetails.getClient());
            updatedPlacement.setVendor(placementDetails.getVendor());
            updatedPlacement.setDoj(placementDetails.getDoj());
            updatedPlacement.setClosedBy(placementDetails.getClosedBy());
            updatedPlacement.setBillRateFromClient(placementDetails.getBillRateFromClient());
            updatedPlacement.setBillRateToCandidate(placementDetails.getBillRateToCandidate());
            updatedPlacement.setPayRate(placementDetails.getPayRate());
            updatedPlacement.setMargin(placementDetails.getMargin());
            updatedPlacement.setProjectIn(placementDetails.getProjectIn());
            updatedPlacement.setClosedMonth(placementDetails.getClosedMonth());
            updatedPlacement.setType(placementDetails.getType());
            updatedPlacement.setVisa(placementDetails.getVisa());

            // Save the updated entity
            return placementRepository.save(updatedPlacement);
        }

        return null; // Return null if the placement does not exist
    }

    // Method to delete a placement by ID
    @Transactional
    public boolean deletePlacement(Long id) {
        if (placementRepository.existsById(id)) {
            placementRepository.deleteById(id);
            System.out.println("Placement deleted with ID: " + id);
            return true; // Return true if the placement was successfully deleted
        }
        return false; // Return false if the placement doesn't exist
    }
}
