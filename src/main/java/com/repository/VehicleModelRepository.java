package com.repository;

import com.domain.dictionary.VehicleModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleModelRepository extends CrudRepository<VehicleModel, Integer> {

    VehicleModel findFirstByname(String name);

    @Query("SELECT model from VehicleModel model where model.categoryId = :categoryId and model.markId = :markId")
    List<VehicleModel> findByCategoryAndMark(@Param("categoryId") int categoryId, @Param("markId") int markId);
}
