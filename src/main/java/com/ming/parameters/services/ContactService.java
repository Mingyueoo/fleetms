package com.ming.parameters.services;

import com.ming.parameters.models.Contact;
import com.ming.parameters.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;
    public List<Contact> findAll(){
        return contactRepository.findAll();

    }

    public Contact findById(Integer id){
        return contactRepository.findById(id).orElse(null);
    }

    public void delete(Integer id){
        contactRepository.deleteById(id);
    }

    public void save(Contact contact){
        contactRepository.save(contact);

    }
}
