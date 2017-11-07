package com.domain.location;

import javax.validation.constraints.NotNull;

public class InputVehicleCoordinate {

    @NotNull
    private double lat;

    @NotNull
    private double lng;

    @NotNull
    private Integer accountingRecordId;

    @NotNull
    private Integer vehicleId;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public Integer getAccountingRecordId() {
        return accountingRecordId;
    }

    public void setAccountingRecordId(Integer accountingRecordId) {
        this.accountingRecordId = accountingRecordId;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }
}
