package com.domain.location;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "vehicle_coordinates")
public class VehicleCoordinate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "lat", nullable = false)
    private double lat;

    @Column(name = "lng", nullable = false)
    private double lng;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @Column(name = "accounting_record_id", nullable = false)
    private Integer accountingRecordId;

    @Column(name = "vehicle_id", nullable = false)
    private Integer vehicleId;

    @Column(name = "vehicle_model_id", nullable = false)
    private Integer vehicleModelId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
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

    public Integer getVehicleModelId() {
        return vehicleModelId;
    }

    public void setVehicleModelId(Integer vehicleModelId) {
        this.vehicleModelId = vehicleModelId;
    }
}
