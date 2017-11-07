package com.service.dictionary;

import com.domain.dictionary.InputVehicleModel;
import com.domain.dictionary.VehicleModel;

import java.util.List;

public interface VehicleModelService {

    /**
     * Get all vehicle models.
     *
     * @return found vehicle models.
     */
    Iterable<VehicleModel> getAll();

    /**
     * Find vehicle model by given name.
     *
     * @param name
     * @return found vehicle model
     */
    VehicleModel findByName(String name);

    /**
     * Find vehicle model by given params.
     *
     * @param categoryId
     * @param markId
     * @return found vehicle model
     */
    List<VehicleModel> findByCategoryAndMark(int categoryId, int markId);

    /**
     * Check if vehicle model with the same info already exists.
     * Create new vehicle model.
     *
     * @param vehicleModel
     * @return created vehicle model
     */
    VehicleModel create(InputVehicleModel vehicleModel);

    /**
     * Delete vehicle model by id.
     *
     * @param id
     */
    void delete(int id);
}
