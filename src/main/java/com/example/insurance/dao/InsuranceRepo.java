package com.example.insurance.dao;

import com.example.insurance.Models.InsurancePolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRepo extends JpaRepository<InsurancePolicy,Integer> {
}
