package com.repository;

import com.domain.dictionary.VehicleMark;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleMarkRepository extends CrudRepository<VehicleMark, Integer> {

    VehicleMark findFirstByname(String name);
}
