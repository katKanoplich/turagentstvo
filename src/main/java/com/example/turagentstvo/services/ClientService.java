package com.example.turagentstvo.services;

import com.example.turagentstvo.entities.Client;

import java.util.List;

public interface ClientService {
    List<Client> getAllClients();
    Client addClient(Client client);
    void deleteClient(long id);
    Client updateClient(long id, Client updateClient);
    Client getById(long id);
}
