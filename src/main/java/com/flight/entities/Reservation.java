package com.flight.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
public class Reservation extends AbstractEntity {
    @Column(name = "checked_in")
    private int checkedIn;
    @Column(name = "number_of_bags") // no need to have @Column because it will convert the camel case to underscore
    private int numberOfBags;
    @OneToOne
    private Passenger passenger;
    @OneToOne
    private Flight flight;
    private Timestamp created;
}
