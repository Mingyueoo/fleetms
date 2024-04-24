package com.ming.parameters.services;

import com.ming.parameters.repositories.CountryRepository;
import com.ming.parameters.models.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;
    public List<Country> getAll(){
        return countryRepository.findAll();
    }

    public void save(Country country){
        countryRepository.save(country);
    }


    public Country getById(Integer id){
        return countryRepository.findById(id).orElse(null);

    }

    public void delete(Integer id){
        countryRepository.deleteById(id);
    }

    public List<Country> findAll() {
        return countryRepository.findAll();
    }
}
