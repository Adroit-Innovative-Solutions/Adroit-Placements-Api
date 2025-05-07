package com.adroit.placements.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Table(name = "placements")
@NoArgsConstructor
public class PlacementDetails {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(name = "consultant_name")
    private String consultantName;

    @Email(message = "Invalid email format")
    @Column(name = "mail_id")
    private String mailId;

    @Column(name = "domain")
    private String domain;

    @Column(name = "client")
    private String client;

    @Column(name = "vendor")
    private String vendor;

    @Column(name = "doj")
    private String doj;

    @Column(name = "closed_by")
    private String closedBy;

    @Column(name = "created_At")
    private LocalDate createdAt;

    // Automatically set the current date
    @PrePersist
    public void prePersist() {
        if (createdAt == null) {
            createdAt = LocalDate.now();
        }
    }

    @DecimalMin(value = "0.0", inclusive = false, message = "Bill Rate From Client must be positive")
    @Digits(integer = 10, fraction = 5, message = "Invalid format for Bill Rate From Client")
    @Column(name = "bill_rate_from_client")
    private BigDecimal billRateFromClient;

    @DecimalMin(value = "0.0", inclusive = false, message = "Bill Rate To Candidate must be positive")
    @Digits(integer = 10, fraction = 5, message = "Invalid format for Bill Rate To Candidate")
    @Column(name = "bill_rate_to_candidate")
    private BigDecimal billRateToCandidate;

    @DecimalMin(value = "0.0", inclusive = false, message = "Pay Rate must be positive")
    @Digits(integer = 10, fraction = 5, message = "Invalid format for Pay Rate")
    @Column(name = "pay_rate")
    private BigDecimal payRate;

    @DecimalMin(value = "0.0", inclusive = true, message = "Margin must be non-negative")
    @Digits(integer = 10, fraction = 5, message = "Invalid format for Margin")
    @Column(name = "margin")
    private BigDecimal margin;

    @Column(name = "project_in")
    private String projectIn;

    @Column(name = "closed_month")
    private String closedMonth;

    @Column(name = "type")
    private String type;

    @Column(name = "visa")
    private String visa;

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

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVisa() {
        return visa;
    }

    public void setVisa(String visa) {
        this.visa = visa;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}


