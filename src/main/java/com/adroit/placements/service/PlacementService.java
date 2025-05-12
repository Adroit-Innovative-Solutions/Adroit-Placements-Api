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
    // Method to get a specific placement by ID (id should be a String)
    public Optional<PlacementDetails> getPlacementById(String id) {
        return placementRepository.findById(id);  // No need to convert to Long
    }

    // Method to add a new placement with custom ID
    @Transactional
    public PlacementDetails addPlacement(PlacementDetails placementDetails) {
        placementDetails.setId(generateCustomId()); // Set custom ID here
        PlacementDetails savedPlacement = placementRepository.save(placementDetails);
        System.out.println("Placement saved with ID: " + savedPlacement.getId());
        return savedPlacement;
    }

    // Method to update an existing placement (id should be a String)
    @Transactional
    public PlacementDetails updatePlacement(String id, PlacementDetails placementDetails) {
        Optional<PlacementDetails> existingPlacement = placementRepository.findById(id); // No need to convert to Long

        if (existingPlacement.isPresent()) {
            PlacementDetails updatedPlacement = existingPlacement.get();

            updatedPlacement.setConsultantName(placementDetails.getConsultantName());
            updatedPlacement.setEmailId(placementDetails.getEmailId());
            updatedPlacement.setTechnology(placementDetails.getTechnology());
            updatedPlacement.setClientName(placementDetails.getClientName());
            updatedPlacement.setVendorName(placementDetails.getVendorName());
            updatedPlacement.setStartDate(placementDetails.getStartDate());
            updatedPlacement.setClosedBy(placementDetails.getClosedBy());
            updatedPlacement.setBillRateFromClient(placementDetails.getBillRateFromClient());
            updatedPlacement.setBillRateToCandidate(placementDetails.getBillRateToCandidate());
            updatedPlacement.setPayRate(placementDetails.getPayRate());
            updatedPlacement.setMargin(placementDetails.getMargin());
            updatedPlacement.setProjectIn(placementDetails.getProjectIn());
            updatedPlacement.setClosedMonth(placementDetails.getClosedMonth());
            updatedPlacement.setEmpolymentType(placementDetails.getEmpolymentType());
            updatedPlacement.setVisa(placementDetails.getVisa());

            return placementRepository.save(updatedPlacement);
        }

        return null;
    }

    // Method to delete a placement by ID (id should be a String)
    @Transactional
    public boolean deletePlacement(String id) {
        if (placementRepository.existsById(id)) {
            placementRepository.deleteById(id);
            System.out.println("Placement deleted with ID: " + id);
            return true;
        }
        return false;
    }

    // Helper method to generate a custom ID like PLMNT0001
    private String generateCustomId() {
        List<Integer> existingNumbers = placementRepository.findAll().stream()
                .map(PlacementDetails::getId)
                .filter(id -> id != null && id.matches("PLMNT\\d{4}"))
                .map(id -> Integer.parseInt(id.replace("PLMNT", "")))
                .toList();

        int nextNumber = existingNumbers.stream().max(Integer::compare).orElse(0) + 1;
        return String.format("PLMNT%04d", nextNumber);
    }
}
