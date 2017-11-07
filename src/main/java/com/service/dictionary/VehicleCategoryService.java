package com.service.dictionary;

import com.domain.dictionary.VehicleCategory;

public interface VehicleCategoryService {
    /**
     * Get all vehicle categories.
     *
     * @return found vehicle categories.
     */
    Iterable<VehicleCategory> getAll();

    /**
     * Find vehicle category by given name.
     *
     * @param name
     * @return found vehicle category
     */
    VehicleCategory findByName(String name);

    /**
     * Check if vehicle category with the same info already exists.
     * Create new vehicle category.
     *
     * @param name
     * @return created vehicle category
     */
    VehicleCategory create(String name);

    /**
     * Delete vehicle category by id.
     *
     * @param id
     */
    void delete(int id);
}