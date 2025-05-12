package com.adroit.placements.dto;

import com.adroit.placements.model.PlacementDetails;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PlacementResponseDto {

    private String id;
    private String consultantName;
    private String emailId;
    private String technology;
    private String clientName;
    private String vendorName;
    private String startDate;
    private String closedBy;
    private BigDecimal billRateFromClient;
    private BigDecimal billRateToCandidate;
    private BigDecimal payRate;
    private BigDecimal margin;
    private String projectIn;
    private String closedMonth;
    private String visa;
    private String createdAt;
    private String empolymentType;

    // Constructor to populate all fields
    public PlacementResponseDto(PlacementDetails placementDetails) {
        this.id = placementDetails.getId();
        this.consultantName = placementDetails.getConsultantName();
        this.emailId = placementDetails.getEmailId();
        this.technology = placementDetails.getTechnology();
        this.clientName = placementDetails.getClientName();
        this.vendorName = placementDetails.getVendorName();
        this.startDate= placementDetails.getStartDate();
        this.closedBy = placementDetails.getClosedBy();
        this.billRateFromClient = placementDetails.getBillRateFromClient();
        this.billRateToCandidate = placementDetails.getBillRateToCandidate();
        this.payRate = placementDetails.getPayRate();
        this.margin = placementDetails.getMargin();
        this.projectIn = placementDetails.getProjectIn();
        this.closedMonth = placementDetails.getClosedMonth();
        this.empolymentType = placementDetails.getEmpolymentType();
        this.visa = placementDetails.getVisa();
        this.createdAt = String.valueOf(placementDetails.getCreatedAt());
    }

    // Static factory method
    public static PlacementResponseDto fromEntity(PlacementDetails placementDetails) {
        return new PlacementResponseDto(placementDetails);
    }
}
