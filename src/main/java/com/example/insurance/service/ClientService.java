package com.example.insurance.service;

import com.example.insurance.Models.Client;
import com.example.insurance.dao.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    ClientRepo clientRepo;

      public List<Client> fetchAllClients()
      {
          return clientRepo.findAll();
      }
      public Client fetchByClientId(int clientId)
      {
          Client clientDetails = clientRepo.findById(clientId);
          return clientDetails;
      }
      public Client createClient(Client c)
      {
          clientRepo.save(c);
          return c;
      }
      public Client updateClient(Client client,int clientId)
      {
          client.setId(clientId);
          clientRepo.save(client);
          return client;
      }
      public Client deleteClient(int cId)
      {
            Client client= clientRepo.findById(cId);
            clientRepo.deleteById(cId);
            return client;
      }

}
