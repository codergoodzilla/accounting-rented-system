package com.domain.renter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "renters")
public class Renter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "full_name", nullable = false, unique = true)
    private String fullName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    //@OneToMany(mappedBy = "renter", fetch = FetchType.LAZY)
    //private Collection<AccountingRented> accountingRented;
}
