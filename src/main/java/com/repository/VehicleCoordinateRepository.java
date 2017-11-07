package com.repository;

import com.domain.location.VehicleCoordinate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleCoordinateRepository extends CrudRepository<VehicleCoordinate, Integer> {
}