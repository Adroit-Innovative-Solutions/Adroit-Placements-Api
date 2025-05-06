package com.adroit.placements.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
public class PlacementDto {

    private String consultantName;

    @Email(message = "Invalid email format")
    private String mailId;

    private String domain;
    private String client;
    private String vendor;
    private String doj;
    private String closedBy;

    @DecimalMin(value = "0.0", inclusive = false, message = "Bill Rate From Client must be positive")
    @Digits(integer = 10, fraction = 5, message = "Invalid format for Bill Rate From Client")
    private BigDecimal billRateFromClient;

    @DecimalMin(value = "0.0", inclusive = false, message = "Bill Rate To Candidate must be positive")
    @Digits(integer = 10, fraction = 5, message = "Invalid format for Bill Rate To Candidate")
    private BigDecimal billRateToCandidate;

    @DecimalMin(value = "0.0", inclusive = false, message = "Pay Rate must be positive")
    @Digits(integer = 10, fraction = 5, message = "Invalid format for Pay Rate")
    private BigDecimal payRate;

    @DecimalMin(value = "0.0", inclusive = true, message = "Margin must be non-negative")
    @Digits(integer = 10, fraction = 5, message = "Invalid format for Margin")
    private BigDecimal margin;

    private String projectIn;
    private String closedMonth;
    private String type;
    private String visa;
}


