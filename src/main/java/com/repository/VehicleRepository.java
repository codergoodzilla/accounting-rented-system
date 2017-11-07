package com.repository;

import com.domain.vehicle.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {

    Vehicle findFirstBylicensePlate(String licensePlate);
}
