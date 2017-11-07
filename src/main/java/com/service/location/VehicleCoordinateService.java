package com.service.location;

import com.domain.location.CoordinateHistory;
import com.domain.location.InputVehicleCoordinate;

import java.util.List;

public interface VehicleCoordinateService {

    /**
     *
     *
     * @param categoryId
     * @param markId
     * @return get statistic by coordinates
     */
    List<CoordinateHistory> getStatisticBy(int categoryId, int markId);

    /**
     *
     *
     * @param coordinate
     * create create coordinate
     */
    void create(InputVehicleCoordinate coordinate);

    /**
     *
     *
     * @param id
     * delete accounting record by id
     */
    void delete(int id);
}
