package com.example.turagentstvo.services.impl;

import com.example.turagentstvo.entities.Client;
import com.example.turagentstvo.repositorys.ClientRepository;
import com.example.turagentstvo.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }
    public Client addClient(Client client){
        clientRepository.save(client);
        return client;
    }
    public void deleteClient(long id) {
        clientRepository.deleteById(id);
    }
    public Client updateClient(long id, Client updateClient) {
        updateClient.setId(id);
        return clientRepository.save(updateClient);
    }
    public Client getById(long id){
        return clientRepository.findById(id).orElseThrow();
    }
}
