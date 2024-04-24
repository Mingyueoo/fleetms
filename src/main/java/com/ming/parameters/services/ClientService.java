package com.ming.parameters.services;
import com.ming.parameters.models.Client;
import com.ming.parameters.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    public List<Client> findAll(){
        return clientRepository.findAll();
    }
    public Client findById(Integer id){
        return clientRepository.findById(id).orElse(null);
    }

    public void delete(Integer id){
        clientRepository.deleteById(id);
    }

    public void save(Client client){
        clientRepository.save(client);
    }
}
