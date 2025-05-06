package com.adroit.placements.controller;


import com.adroit.placements.dto.PlacementResponseDto;
import com.adroit.placements.model.PlacementDetails;
import com.adroit.placements.service.PlacementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/candidate")
public class PlacementController {

    @Autowired
    private PlacementService placementService;

    // Create a new placement
    @PostMapping(value = "/placements/save", consumes = "application/json", produces = "application/json")
    public ResponseEntity<PlacementResponseDto> addPlacement(@RequestBody PlacementDetails placementDetails) {
        PlacementDetails savedPlacement = placementService.addPlacement(placementDetails);
        PlacementResponseDto response = PlacementResponseDto.fromEntity(savedPlacement);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Get all placements
    @GetMapping("/placements/getAllplacement")
    public ResponseEntity<List<PlacementResponseDto>> getAllPlacements() {
        List<PlacementDetails> placements = placementService.getAllPlacements();
        List<PlacementResponseDto> responseList = placements.stream()
                .map(PlacementResponseDto::fromEntity)
                .toList();
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

    // Get a placement by ID
    @GetMapping("/placements/{id}")
    public ResponseEntity<PlacementResponseDto> getPlacementById(@PathVariable Long id) {
        Optional<PlacementDetails> placement = placementService.getPlacementById(id);
        if (placement.isPresent()) {
            PlacementResponseDto response = PlacementResponseDto.fromEntity(placement.get());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update a placement by ID
    @PutMapping("/updateplacement/{id}")
    public ResponseEntity<PlacementResponseDto> updatePlacement(@PathVariable Long id, @RequestBody PlacementDetails placementDetails) {
        PlacementDetails updatedPlacement = placementService.updatePlacement(id, placementDetails);
        if (updatedPlacement != null) {
            PlacementResponseDto response = PlacementResponseDto.fromEntity(updatedPlacement);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a placement by ID
    @DeleteMapping("/deleteplacement/{id}")
    public ResponseEntity<Void> deletePlacement(@PathVariable Long id) {
        boolean isDeleted = placementService.deletePlacement(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
