package com.example.insurance.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity(name = "claimEntity")
public class Claim {
    @Id
    @GeneratedValue
    int claim_id;
    int claimNumber;
    String description;
    LocalDate claimDate;
    String claimStatus;

    public Claim() {
    }

    public Claim(int claim_id, int claimNumber, String description, LocalDate claimDate, String claimStatus) {
        this.claim_id = claim_id;
        this.claimNumber = claimNumber;
        this.description = description;
        this.claimDate = claimDate;
        this.claimStatus = claimStatus;
    }

    public int getClaimNumber() {
        return claimNumber;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getClaimDate() {
        return claimDate;
    }

    public String getClaimStatus() {
        return claimStatus;
    }

    public void setClaimNumber(int claimNumber) {
        this.claimNumber = claimNumber;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setClaimDate(LocalDate claimDate) {
        this.claimDate = claimDate;
    }

    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus;
    }
}
