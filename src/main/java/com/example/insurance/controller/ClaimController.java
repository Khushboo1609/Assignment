package com.example.insurance.controller;

import com.example.insurance.Models.Claim;
import com.example.insurance.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ClaimController {
    @Autowired
    ClaimService claimService;

    @GetMapping("/claims")
    ResponseEntity< List<Claim>> getListOfClaims()
    {
        List<Claim> claims= claimService.fetchAllClaims();
        if(claims.size()==0) return new ResponseEntity<>(HttpStatusCode.valueOf(404));
        return new ResponseEntity<>(claims,HttpStatusCode.valueOf(200));
    }

    @GetMapping("/claims/{id}")
   ResponseEntity<Claim> getClaim(@PathVariable int claimId)
    {
        Claim claim= claimService.fetchById(claimId);
        if(claim==null)
            return new ResponseEntity<>(HttpStatusCode.valueOf(404));
        return new ResponseEntity<>(claim,HttpStatusCode.valueOf(200));
    }

    @PostMapping("/claims")
    void PostClaims(@RequestBody Claim claim)
    {
        claimService.createClaim(claim);
    }



    @PutMapping("/claims/{id}")
    void updateClaim(@PathVariable(value = "id") int id, @RequestBody Claim claim){
        claimService.updateClaim(claim, id);
    }

    @DeleteMapping("/claims/{id}")
    ResponseEntity<Claim> DeleteClaims(@PathVariable int  claimId)
    {
       Claim claim= claimService. deleteClaim(claimId);
       if(claim== null)  return new ResponseEntity<>(HttpStatusCode.valueOf(404));
        return new ResponseEntity<>(claim,HttpStatusCode.valueOf(200));
    }


}

