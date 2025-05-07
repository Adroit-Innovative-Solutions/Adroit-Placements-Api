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
    private String mailId;
    private String domain;
    private String client;
    private String vendor;
    private String doj;
    private String closedBy;
    private BigDecimal billRateFromClient;
    private BigDecimal billRateToCandidate;
    private BigDecimal payRate;
    private BigDecimal margin;
    private String projectIn;
    private String closedMonth;
    private String type;
    private String visa;
    private String createdAt;

    // Constructor to populate all fields
    public PlacementResponseDto(PlacementDetails placementDetails) {
        this.id = placementDetails.getId();
        this.consultantName = placementDetails.getConsultantName();
        this.mailId = placementDetails.getMailId();
        this.domain = placementDetails.getDomain();
        this.client = placementDetails.getClient();
        this.vendor = placementDetails.getVendor();
        this.doj = placementDetails.getDoj();
        this.closedBy = placementDetails.getClosedBy();
        this.billRateFromClient = placementDetails.getBillRateFromClient();
        this.billRateToCandidate = placementDetails.getBillRateToCandidate();
        this.payRate = placementDetails.getPayRate();
        this.margin = placementDetails.getMargin();
        this.projectIn = placementDetails.getProjectIn();
        this.closedMonth = placementDetails.getClosedMonth();
        this.type = placementDetails.getType();
        this.visa = placementDetails.getVisa();
        this.createdAt = String.valueOf(placementDetails.getCreatedAt());
    }

    // Static factory method
    public static PlacementResponseDto fromEntity(PlacementDetails placementDetails) {
        return new PlacementResponseDto(placementDetails);
    }
}
