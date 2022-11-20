package com.flight.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@ToString
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
