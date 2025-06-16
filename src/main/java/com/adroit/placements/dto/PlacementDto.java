package com.adroit.placements.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlacementDto {

    private String consultantName;
    private String emailId;
    private LocalDate createdAt;
    private String technology;
    private String clientName;
    private String vendorName;
    private String startDate;
    private String closedBy;
    private String projectIn;
    private String closedMonth;
    private String employementType;
    private String visa;
    private BigDecimal billRateFromClient;
    private BigDecimal billRateToCandidate;
    private BigDecimal payRate;
    private BigDecimal margin;
}
