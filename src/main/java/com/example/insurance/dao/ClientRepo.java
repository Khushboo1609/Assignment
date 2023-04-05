package com.example.insurance.dao;

import com.example.insurance.Models.Client;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends JpaRepository<Client, Id> {
    Client findById(int clientId);

    void deleteById(int clientId);



}
