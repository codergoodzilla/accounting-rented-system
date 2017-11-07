package com.domain.renter;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class InputRenter {

    @NotNull
    @Length(min = 1, max = 255)
    private String fullName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
