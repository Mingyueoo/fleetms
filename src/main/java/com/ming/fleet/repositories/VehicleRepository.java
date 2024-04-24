package com.ming.fleet.repositories;

import com.ming.fleet.models.Vehicle;
import com.ming.fleet.models.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleType, Integer> {
}
