package com.service.accounting;

import com.domain.accounting.AccountingHistory;
import com.domain.accounting.AccountingHistoryMapper;
import com.domain.accounting.AccountingRecord;
import com.domain.accounting.InputAccountingRecord;
import com.domain.renter.Renter;
import com.domain.vehicle.Vehicle;
import com.repository.AccountingRecordRepository;
import com.repository.RenterRepository;
import com.repository.VehicleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class AccountingRecordServiceImpl implements AccountingRecordService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    private RenterRepository renterRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private AccountingRecordRepository accountingRecordRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Integer> findAll() {

        List<Integer> result =
                jdbcTemplate.queryForList(
                        "SELECT id FROM accounting_records", Integer.class );
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountingHistory findById(int id) {

        AccountingHistory result =
            jdbcTemplate.queryForObject(
                "SELECT \n" +
                        "vehicle_categories.name AS categoryName, \n" +
                        "vehicle_marks.name AS markName, \n" +
                        "rental_start_at AS rentalStartDate, \n" +
                        "rental_end_at AS rentalEndDate, \n" +
                        "renters.full_name AS renterFullName, \n" +
                        "vehicles.license_plate AS licensePlate \n" +
                     "FROM accounting_records accounting\n" +
                        "join vehicles on accounting.rented_vehicle_id = vehicles.id\n" +
                        "join vehicle_models on vehicles.model_id = vehicle_models.id\n" +
                        "join vehicle_categories on vehicle_models.category_id = vehicle_categories.id\n" +
                        "join vehicle_marks on vehicle_models.mark_id = vehicle_marks.id\n" +
                        "join renters on accounting.renter_id = renters.id\n" +
                     "where accounting.id = ?",
                new AccountingHistoryMapper(), id );
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void create(InputAccountingRecord record)
    {
        Renter existRenter = renterRepository.findOne(record.getRenterId());
        Assert.notNull(existRenter, "renter with same id does not exists: " + record.getRenterId());

        Vehicle existVehicle = vehicleRepository.findOne(record.getVehicleId());
        Assert.notNull(existVehicle, "vehicle with same id does not exists: " + record.getVehicleId());

        boolean isExpired = (record.getRentalStartDate().getTime() >= record.getRentalEndDate().getTime());
        Assert.isTrue(isExpired, "rental timing period is not valid");

        AccountingRecord accountingRecord = new AccountingRecord();
        accountingRecord.setRenterId(record.getRenterId());
        accountingRecord.setVehicleId(record.getVehicleId());
        accountingRecord.setRentalStartDate(record.getRentalStartDate());
        accountingRecord.setRentalEndDate(record.getRentalEndDate());

        long milliseconds = record.getRentalEndDate().getTime() - record.getRentalStartDate().getTime();
        int seconds = (int) milliseconds / 1000;
        int hours = seconds / 3600;

        accountingRecord.setRentalHoursCount(hours);
        accountingRecord.setRentalCoordinatesCount(0);

        accountingRecordRepository.save(accountingRecord);

        log.info("new accounting record has been created");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(int id) {

        AccountingRecord existing = accountingRecordRepository.findOne(id);
        Assert.notNull(existing, "accounting record with same id does not exists: " + id);

        accountingRecordRepository.delete(id);

        log.info("accounting record has been deleted: " + id);
    }

}
