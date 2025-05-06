package com.adroit.placements.dto;

import com.adroit.placements.model.PlacementDetails;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PlacementResponseDto {

    private Long id;
    private String consultantName;
    private String mailId;
    private String client;

    // Constructor for converting PlacementDetails entity to DTO
    public PlacementResponseDto(Long id, String consultantName, @Email(message = "Invalid email format") String mailId, String client) {
        this.id = id;
        this.consultantName = consultantName;
        this.mailId = mailId;
        this.client = client;
    }

    // Static factory method for creating DTO from PlacementDetails entity
    public static PlacementResponseDto fromEntity(PlacementDetails placementDetails) {
        return new PlacementResponseDto(
                placementDetails.getId(),
                placementDetails.getConsultantName(),
                placementDetails.getMailId(),
                placementDetails.getClient()
        );
    }
}
