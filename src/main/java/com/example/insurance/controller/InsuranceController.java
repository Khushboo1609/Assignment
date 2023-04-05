package com.example.insurance.controller;

import com.example.insurance.Models.InsurancePolicy;
import com.example.insurance.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class InsuranceController {
    @Autowired
    InsuranceService insuranceService;

    @GetMapping("/policies")
    ResponseEntity<List<InsurancePolicy>>getListOfInsurances()
    {
        List<InsurancePolicy> insurancePolicy= insuranceService.fetchAllInsurance();
        if(insurancePolicy.size()==0) return new ResponseEntity<>(HttpStatusCode.valueOf(400));
        return new ResponseEntity<>( insurancePolicy, HttpStatusCode.valueOf(200));
    }


    @GetMapping("/policies/{id}")
    ResponseEntity<InsurancePolicy> getPolicyById(@PathVariable int PolicyId)
    {
        InsurancePolicy insurancePolicy= insuranceService.fetchByInsuranceId(PolicyId);
        if(insurancePolicy==null) return new ResponseEntity<>(HttpStatusCode.valueOf(400));
        return new ResponseEntity<>( insurancePolicy, HttpStatusCode.valueOf(200));

    }

    @PostMapping("/policies")
    void createPolicy(@RequestBody InsurancePolicy policy )
    {

        insuranceService.createPolicy( policy);
    }



    @PutMapping("/policies/{id}")
    void updatePolicy(@RequestBody InsurancePolicy policy, @PathVariable(value="id") int id){
        insuranceService.updatePolicy(id,policy);
    }


    @DeleteMapping("/policies/{id}")
    ResponseEntity<InsurancePolicy> DeletePolicy(@PathVariable int  policyId)
    {
        InsurancePolicy insurancePolicy= insuranceService.deletePolicy(policyId);
        if(insurancePolicy==null) return new ResponseEntity<>(HttpStatusCode.valueOf(400));
        return new ResponseEntity<>( insurancePolicy, HttpStatusCode.valueOf(200));
    }

}

