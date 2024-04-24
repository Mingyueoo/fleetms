package com.ming.parameters.services;

import com.ming.parameters.models.Location;
import com.ming.parameters.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;
    //get all
    public List<Location> findAll(){
        return locationRepository.findAll();
    }
    // get location by ID
    public Location findById(Integer id){
        return locationRepository.findById(id).orElse(null);
    }
    //delete location by id
    public void delete(Integer id){
        locationRepository.deleteById(id);
    }

    //update location
    public void save(Location location){
        locationRepository.save(location);
    }

}
