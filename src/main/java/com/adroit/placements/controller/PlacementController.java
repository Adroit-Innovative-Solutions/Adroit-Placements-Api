package com.adroit.placements.controller;

import com.adroit.placements.dto.PlacementResponseDto;
import com.adroit.placements.model.PlacementDetails;
import com.adroit.placements.service.PlacementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@CrossOrigin(origins = {
        "http://35.188.150.92",
        "http://192.168.0.140:3000",
        "http://192.168.0.139:3000",
        "https://mymulya.com",
        "http://localhost:3000",
        "http://192.168.0.135:8080", // Sixth IP
        "http://182.18.177.16:443", // Seventh IP
        "http://192.168.0.135:80", // Eighth IP
        "http://localhost/", // Ninth IP
        "http://mymulya.com:443", // Tenth IP
        "http://192.0.168.246:3002",
})

@RestController
@RequestMapping("/adroit")
public class PlacementController {

    @Autowired
    private PlacementService placementService;

    private ResponseEntity<Object> buildResponse(boolean success, String message, Object data, HttpStatus status) {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("success", success);
        response.put("message", message);
        response.put("timestamp", LocalDateTime.now());
        response.put("data", data);
        return new ResponseEntity<>(response, status);
    }


    @PostMapping("/placements/save")
    public ResponseEntity<Object> addPlacement(@RequestBody PlacementDetails placementDetails) {
        try {
            PlacementDetails savedPlacement = placementService.addPlacement(placementDetails);

            // Constructing the response object with the custom ID
            Map<String, Object> data = new HashMap<>();
            data.put("id", savedPlacement.getId());  // Now savedPlacement.getId() will return the custom "PLMNT0001" ID
            data.put("consultantName", savedPlacement.getConsultantName());
            data.put("mailId", savedPlacement.getEmailId());
            data.put("client", savedPlacement.getClientName());  // Assuming it's "client" not "mailId"

            return buildResponse(true, "Placement saved successfully", data, HttpStatus.OK);
        } catch (Exception e) {
            return buildResponse(false, "Failed to save placement: " + e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/placements/getAllplacement")
    public ResponseEntity<Object> getAllPlacements() {
        try {
            List<PlacementDetails> placements = placementService.getAllPlacements();
            List<PlacementResponseDto> responseList = placements.stream()
                    .map(PlacementResponseDto::fromEntity)
                    .toList();

            return buildResponse(true, "Placements fetched successfully", responseList, HttpStatus.OK);
        } catch (Exception e) {
            return buildResponse(false, "Failed to fetch placements: " + e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/placements/{id}")
    public ResponseEntity<Object> getPlacementById(@PathVariable String id) {
        try {
            Optional<PlacementDetails> placement = placementService.getPlacementById(id);
            if (placement.isPresent()) {
                PlacementResponseDto response = PlacementResponseDto.fromEntity(placement.get());
                return buildResponse(true, "Placement found", response, HttpStatus.OK);
            } else {
                return buildResponse(false, "Placement not found", null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return buildResponse(false, "Error retrieving placement: " + e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateplacement/{id}")
    public ResponseEntity<Object> updatePlacement(@PathVariable String id, @RequestBody PlacementDetails placementDetails) {
        try {
            // Use String id directly (no conversion to Long)
            PlacementDetails updatedPlacement = placementService.updatePlacement(id, placementDetails);
            if (updatedPlacement != null) {
                PlacementResponseDto response = PlacementResponseDto.fromEntity(updatedPlacement);
                return buildResponse(true, "Placement updated successfully", response, HttpStatus.OK);
            } else {
                return buildResponse(false, "Placement not found", null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return buildResponse(false, "Failed to update placement: " + e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/deleteplacement/{id}")
    public ResponseEntity<Object> deletePlacement(@PathVariable String id) {  // Changed to String
        try {
            // Pass the id directly as a String
            boolean isDeleted = placementService.deletePlacement(id);  // Use the id as a String
            if (isDeleted) {
                // Use HttpStatus.OK to return content in the response body
                return buildResponse(true, "Placement deleted successfully", null, HttpStatus.OK);
            } else {
                return buildResponse(false, "Placement not found", null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return buildResponse(false, "Failed to delete placement: " + e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
