package com.domain.accounting;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "accounting_records")
public class AccountingRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "renter_id", nullable = false)
    private Integer renterId;

    @Column(name = "rented_vehicle_id", nullable = false)
    private Integer vehicleId;

    @Column(name = "rental_start_at", nullable = false)
    private Timestamp rentalStartDate;

    @Column(name = "rental_end_at", nullable = false)
    private Timestamp rentalEndDate;

    @Column(name = "rental_hours_count", nullable = false)
    private Integer rentalHoursCount;

    @Column(name = "rental_coordinates_count", nullable = false)
    private Integer rentalCoordinatesCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRenterId() {
        return renterId;
    }

    public void setRenterId(Integer renterId) {
        this.renterId = renterId;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Timestamp getRentalStartDate() {
        return rentalStartDate;
    }

    public void setRentalStartDate(Timestamp rentalStartDate) {
        this.rentalStartDate = rentalStartDate;
    }

    public Timestamp getRentalEndDate() {
        return rentalEndDate;
    }

    public void setRentalEndDate(Timestamp rentalEndDate) {
        this.rentalEndDate = rentalEndDate;
    }

    public Integer getRentalHoursCount() {
        return rentalHoursCount;
    }

    public void setRentalHoursCount(Integer rentalHoursCount) {
        this.rentalHoursCount = rentalHoursCount;
    }

    public Integer getRentalCoordinatesCount() {
        return rentalCoordinatesCount;
    }

    public void setRentalCoordinatesCount(Integer rentalCoordinatesCount) {
        this.rentalCoordinatesCount = rentalCoordinatesCount;
    }
}
