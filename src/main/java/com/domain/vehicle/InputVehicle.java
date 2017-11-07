package com.domain.vehicle;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class InputVehicle {

    @NotNull
    @Length(min = 1, max = 45)
    private String licensePlate;

    @NotNull
    private Integer modelId;

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }
}
