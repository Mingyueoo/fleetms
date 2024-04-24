package com.ming.fleet.services;

import com.ming.fleet.models.VehicleType;
import com.ming.fleet.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleTypeService {
    @Autowired
    private VehicleRepository vehicleRepository;
    public List<VehicleType> findAll(){
        return vehicleRepository.findAll();
    }

    public VehicleType findById(Integer id){
        return vehicleRepository.findById(id).orElse(null);
    }


    public void  delete(Integer id){
        vehicleRepository.deleteById(id);
    }

    public void save(VehicleType vehicleType){
        vehicleRepository.save(vehicleType);
    }


}
