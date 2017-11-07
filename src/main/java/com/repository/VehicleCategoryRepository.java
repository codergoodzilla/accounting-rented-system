package com.repository;

import com.domain.dictionary.VehicleCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleCategoryRepository extends CrudRepository<VehicleCategory, Integer> {

    VehicleCategory findFirstByname(String name);
}
