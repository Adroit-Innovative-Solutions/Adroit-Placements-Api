package com.adroit.placements.dto;

import com.adroit.placements.model.PlacementDetails;
import lombok.Data;
import java.math.BigDecimal;

@Data // <-- This includes @Getter, @Setter, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor
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

    public PlacementResponseDto(PlacementDetails placementDetails) {
        this.id = placementDetails.getId();
        this.consultantName = placementDetails.getConsultantName();
        this.emailId = placementDetails.getEmailId();
        this.technology = placementDetails.getTechnology();
        this.clientName = placementDetails.getClientName();
        this.vendorName = placementDetails.getVendorName();
        this.startDate = placementDetails.getStartDate();
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

    public static PlacementResponseDto fromEntity(PlacementDetails placementDetails) {
        return new PlacementResponseDto(placementDetails);
    }

    public PlacementResponseDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConsultantName() {
        return consultantName;
    }

    public void setConsultantName(String consultantName) {
        this.consultantName = consultantName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getClosedBy() {
        return closedBy;
    }

    public void setClosedBy(String closedBy) {
        this.closedBy = closedBy;
    }

    public BigDecimal getBillRateFromClient() {
        return billRateFromClient;
    }

    public void setBillRateFromClient(BigDecimal billRateFromClient) {
        this.billRateFromClient = billRateFromClient;
    }

    public BigDecimal getBillRateToCandidate() {
        return billRateToCandidate;
    }

    public void setBillRateToCandidate(BigDecimal billRateToCandidate) {
        this.billRateToCandidate = billRateToCandidate;
    }

    public BigDecimal getPayRate() {
        return payRate;
    }

    public void setPayRate(BigDecimal payRate) {
        this.payRate = payRate;
    }

    public BigDecimal getMargin() {
        return margin;
    }

    public void setMargin(BigDecimal margin) {
        this.margin = margin;
    }

    public String getProjectIn() {
        return projectIn;
    }

    public void setProjectIn(String projectIn) {
        this.projectIn = projectIn;
    }

    public String getClosedMonth() {
        return closedMonth;
    }

    public void setClosedMonth(String closedMonth) {
        this.closedMonth = closedMonth;
    }

    public String getVisa() {
        return visa;
    }

    public void setVisa(String visa) {
        this.visa = visa;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getEmpolymentType() {
        return empolymentType;
    }

    public void setEmpolymentType(String empolymentType) {
        this.empolymentType = empolymentType;
    }
}