package com.domain.accounting;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

public class InputAccountingRecord {

    @NotNull
    private Integer renterId;

    @NotNull
    private Integer vehicleId;

    @NotNull
    private Timestamp rentalStartDate;

    @NotNull
    private Timestamp rentalEndDate;

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
}
