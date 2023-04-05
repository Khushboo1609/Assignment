package com.example.insurance.controller;

import com.example.insurance.Models.Client;
import com.example.insurance.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class ClientController {
    @Autowired
    ClientService clientService;

    @GetMapping("/clients")
    ResponseEntity<List<Client>> getListOfClients()
    {
        List<Client> clientList= clientService.fetchAllClients();
        ResponseEntity<List<Client>>clientResponseEntity= new ResponseEntity(clientList,HttpStatusCode.valueOf(200));

        if(clientList.size()==0)
            return new ResponseEntity<>(HttpStatusCode.valueOf(400));

        return clientResponseEntity;
    }


    @GetMapping("/clients/{id}")
    ResponseEntity<Client> getClientDetails(@PathVariable(value = "id") int clientId)
    {
        Client client = clientService.fetchByClientId(clientId);
        ResponseEntity<Client> clientResponseEntity= new ResponseEntity<>(client, HttpStatusCode.valueOf(200));
        if(client==null)
            return new ResponseEntity<>(HttpStatusCode.valueOf(404));
        return clientResponseEntity;
    }

    @PostMapping("/clients")
    ResponseEntity<Client> postClients(@RequestBody Client client)
    {
        Client client1= clientService.createClient(client);
        return new ResponseEntity<>(client, HttpStatusCode.valueOf(202));
    }

    @PutMapping("/clients/{id}")
    void updateClient(@RequestBody Client client, @PathVariable(value = "id") int id){

        clientService.updateClient(client,id);
    }

    @DeleteMapping("/clients/{id}")
    ResponseEntity<Client> DeleteClient(@PathVariable int  clientId)
    {
        Client client= clientService.deleteClient(clientId);
        if(client==null){
            return new ResponseEntity<>(HttpStatusCode.valueOf(404));
        }
        return new ResponseEntity<>(client, HttpStatusCode.valueOf(200));
    }


}
