package com.service.location;

import com.domain.accounting.AccountingRecord;
import com.domain.location.CoordinateHistory;
import com.domain.location.CoordinateHistoryMapper;
import com.domain.location.InputVehicleCoordinate;
import com.domain.location.VehicleCoordinate;
import com.domain.vehicle.Vehicle;
import com.repository.AccountingRecordRepository;
import com.repository.VehicleCoordinateRepository;
import com.repository.VehicleModelRepository;
import com.repository.VehicleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class VehicleCoordinateServiceImpl  implements VehicleCoordinateService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private VehicleModelRepository modelRepository;

    @Autowired
    private VehicleCoordinateRepository coordinateRepository;

    @Autowired
    private AccountingRecordRepository accountingRecordRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CoordinateHistory> getStatisticBy(int categoryId, int markId) {

        List<Integer> modelIds =
                modelRepository.findByCategoryAndMark(categoryId, markId).stream().map(model -> model.getId()).collect(Collectors.toList());

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("ids", modelIds);

        List<CoordinateHistory> result =
                jdbcTemplate.query(
                        "SELECT \n" +
                                "    lat, \n" +
                                "    lng,\n" +
                                "    ((SUM(accounting_records.rental_hours_count) :: DOUBLE PRECISION) / SUM(accounting_records.rental_coordinates_count)) AS accountingTiming\n" +
                              "FROM vehicle_coordinates\n" +
                              "JOIN accounting_records ON accounting_record_id = accounting_records.id\n" +
                              "WHERE vehicle_model_id IN ( :ids )\n" +
                              "GROUP BY lat, lng",
                        new CoordinateHistoryMapper(), params);
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void create(InputVehicleCoordinate coordinate)
    {
        AccountingRecord existAccountingRecord = accountingRecordRepository.findOne(coordinate.getAccountingRecordId());
        Assert.notNull(existAccountingRecord, "accounting record with same id does not exists: " + coordinate.getAccountingRecordId());

        Vehicle existVehicle = vehicleRepository.findOne(coordinate.getVehicleId());
        Assert.notNull(existVehicle, "vehicle with same id does not exists: " + coordinate.getVehicleId());

        Timestamp currentDate = new Timestamp(System.currentTimeMillis());
        boolean isInvalid =
                (currentDate.getTime() < existAccountingRecord.getRentalStartDate().getTime()) &&
                (currentDate.getTime() > existAccountingRecord.getRentalEndDate().getTime());
        Assert.isTrue(isInvalid, "coordinate timestamp not included in accounting record period");

        VehicleCoordinate vehicleCoordinate = new VehicleCoordinate();
        vehicleCoordinate.setLat(coordinate.getLat());
        vehicleCoordinate.setLng(coordinate.getLng());
        vehicleCoordinate.setCreatedAt(currentDate);
        vehicleCoordinate.setAccountingRecordId(coordinate.getAccountingRecordId());
        vehicleCoordinate.setVehicleId(coordinate.getVehicleId());
        vehicleCoordinate.setVehicleModelId(existVehicle.getModelId());

        existAccountingRecord.setRentalCoordinatesCount(existAccountingRecord.getRentalCoordinatesCount() + 1);

        coordinateRepository.save(vehicleCoordinate);
        accountingRecordRepository.save(existAccountingRecord);

        log.info("new accounting record has been created");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(int id) {

        VehicleCoordinate existing = coordinateRepository.findOne(id);
        Assert.notNull(existing, "coordinate with same id does not exists: " + id);

        coordinateRepository.delete(id);

        log.info("coordinate has been deleted: " + id);
    }
}
