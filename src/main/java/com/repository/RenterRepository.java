package com.repository;

import com.domain.renter.Renter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RenterRepository extends CrudRepository<Renter, Integer> {

    Renter findFirstByfullName(String fullName);
}
