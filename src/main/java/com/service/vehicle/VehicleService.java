package com.service.vehicle;

import com.domain.vehicle.InputVehicle;
import com.domain.vehicle.Vehicle;

public interface VehicleService {

    /**
     * Finds vehicles by given licensePlate
     *
     * @param licensePlate
     * @return found vehicles
     */
    Vehicle findByLicensePlate(String licensePlate);

    /**
     * Checks if rented vehicle with the same info already exists
     * Creates new rented vehicle
     *
     * @param rentedVehicle
     * @return created vehicle
     */
    Vehicle create(InputVehicle rentedVehicle);

    /**
     * Delete vehicle by id
     *
     * @param id
     */
    void delete(int id);
}
