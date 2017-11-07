package com.service.renter;

import com.domain.renter.InputRenter;
import com.domain.renter.Renter;

public interface RenterService {

    /**
     * Finds renters by given name
     *
     * @param fullName
     * @return found renters
     */
    Renter findByName(String fullName);

    /**
     * Checks if renter account with the same name already exists
     * Creates new renter entity
     *
     * @param inputRenter
     * @return created renterAccount
     */
    Renter create(InputRenter inputRenter);

    /**
     * Delete renter by id
     *
     * @param id
     */
    void delete(int id);
}
