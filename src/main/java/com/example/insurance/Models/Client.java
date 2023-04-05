package com.example.insurance.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
@Entity
public class Client {
    @Id
    @GeneratedValue
    int id;
    String name;
    LocalDate dateOfBirth;
    String address;
    String contactInformation;
    @OneToOne
    InsurancePolicy insurance_Policy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public InsurancePolicy getInsurance_Policy() {
        return insurance_Policy;
    }

    public void setInsurance_Policy(InsurancePolicy insurance_Policy) {
        this.insurance_Policy = insurance_Policy;
    }

    public Client() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }
}
