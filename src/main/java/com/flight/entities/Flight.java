package com.flight.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
public class Flight extends AbstractEntity{
    @Column(name = "flight_number")
    private String flightNumber;
    @Column(name = "operating_airlines")
    private String operatingAirlines;
    @Column(name = "departure_city")
    private String departureCity;
    @Column(name = "arrival_city")
    private String arrivalCity;
    @Column(name = "date_of_departure")
    private Date dateOfDeparture;
    @Column(name = "estimated_departure_time")
    private Timestamp estimatedDepartureTime;
}
