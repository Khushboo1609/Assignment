package com.example.insurance.service;

import com.example.insurance.Models.InsurancePolicy;
import com.example.insurance.dao.InsuranceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceService {
    @Autowired
    InsuranceRepo insuranceRepo;

    public List<InsurancePolicy> fetchAllInsurance()
    {
        return insuranceRepo.findAll();
    }
    public InsurancePolicy fetchByInsuranceId(int policyId)
    {
        return insuranceRepo.findById(policyId).get();
    }
    public void createPolicy(InsurancePolicy ip)
    {

        insuranceRepo.save(ip);
    }
    public void updatePolicy(int iId, InsurancePolicy insurancePolicy)
    {
        insurancePolicy.setPolicyNumber(iId);
        insuranceRepo.save(insurancePolicy);
    }
    public InsurancePolicy deletePolicy(int pId)
    {
        InsurancePolicy insurancePolicy=  insuranceRepo.findById(pId).get();
        insuranceRepo.deleteById(pId);
        return insurancePolicy;
    }

}




