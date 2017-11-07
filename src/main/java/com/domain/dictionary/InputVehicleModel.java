package com.domain.dictionary;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class InputVehicleModel {

    @NotNull
    @Length(min = 1, max = 45)
    private String name;

    @NotNull
    private Integer categotyId;

    @NotNull
    private Integer markId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategotyId() {
        return categotyId;
    }

    public void setCategotyId(Integer categotyId) {
        this.categotyId = categotyId;
    }

    public Integer getMarkId() {
        return markId;
    }

    public void setMarkId(Integer markId) {
        this.markId = markId;
    }
}
