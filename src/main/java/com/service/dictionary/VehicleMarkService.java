package com.service.dictionary;

import com.domain.dictionary.VehicleMark;

public interface VehicleMarkService {

    /**
     * Get all vehicle marks.
     *
     * @return found vehicle marks.
     */
    Iterable<VehicleMark> getAll();

    /**
     * Find vehicle mark by given name.
     *
     * @param name
     * @return found vehicle mark
     */
    VehicleMark findByName(String name);

    /**
     * Check if vehicle mark with the same info already exists.
     * Create new vehicle mark.
     *
     * @param name
     * @return created vehicle mark
     */
    VehicleMark create(String name);

    /**
     * Delete vehicle mark by id.
     *
     * @param id
     */
    void delete(int id);
}
