package com.example.insurance.service;

import com.example.insurance.Models.Claim;
import com.example.insurance.dao.ClaimRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaimService {
    @Autowired
    ClaimRepo claimRepo;

    public List<Claim> fetchAllClaims()
    {
        return claimRepo.findAll();
    }

    public Claim fetchById(int claimId)
    {
        return claimRepo.findById(claimId).get();
    }

    public Claim createClaim(Claim claim)
    {
       return claimRepo.save(claim);
    }

    public Claim updateClaim(Claim claim,int claimId)
    {
        claim.setClaimNumber(claimId);
        return claimRepo.save(claim);

    }
    public Claim deleteClaim(int claimId)
    {
        Claim claim= claimRepo.findById(claimId).get();
        if(claim==null) return null;
        claimRepo.deleteById(claimId);
        return claim;
    }

}


