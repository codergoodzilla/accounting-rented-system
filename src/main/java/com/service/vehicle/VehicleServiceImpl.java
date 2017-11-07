package com.service.vehicle;

import com.domain.dictionary.VehicleModel;
import com.domain.vehicle.InputVehicle;
import com.domain.vehicle.Vehicle;
import com.repository.VehicleModelRepository;
import com.repository.VehicleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private VehicleRepository repository;

    @Autowired
    private VehicleModelRepository modelRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Vehicle findByLicensePlate(String licensePlate) {
        Assert.hasLength(licensePlate);
        return repository.findFirstBylicensePlate(licensePlate);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Vehicle create(InputVehicle inputVehicle) {

        Vehicle existing = repository.findFirstBylicensePlate(inputVehicle.getLicensePlate());
        Assert.isNull(existing, "vehicle with same license plate already exists: " + inputVehicle.getLicensePlate());

        VehicleModel existModel = modelRepository.findOne(inputVehicle.getModelId());
        Assert.notNull(existModel, "vehicle model with same id does not exists: " + inputVehicle.getModelId());

        Vehicle rentedVehicle = new Vehicle();
        rentedVehicle.setModelId(existModel.getId());
        rentedVehicle.setLicensePlate(inputVehicle.getLicensePlate());

        repository.save(rentedVehicle);

        log.info("new vehicle has been created: " + rentedVehicle.getLicensePlate());

        return rentedVehicle;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(int id) {

        Vehicle existing = repository.findOne(id);
        Assert.notNull(existing, "vehicle with same id does not exists: " + id);

        repository.delete(existing.getId());

        log.info("vehicle has been deleted: " + id);
    }
}