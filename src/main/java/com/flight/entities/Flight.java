package com.flight.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Data
@Component
public class Flight extends AbstractEntity {
    @Column(name = "flight_number")
    @Size(min = 3, message = "Flight number should be more than 3")
    private String flightNumber;

    @NotBlank(message = "operatingAirlines can't be blank")
    @Column(name = "operating_airlines")
    private String operatingAirlines;

    @NotBlank(message = "departureCity can't be blank")
    @Column(name = "departure_city")
    private String departureCity;

    @NotBlank(message = "arrivalCity can't be blank")
    @Column(name = "arrival_city")
    private String arrivalCity;

    @Future(message = "dateOfDeparture must be in future")
    @Column(name = "date_of_departure")
    private Date dateOfDeparture;

    @Column(name = "estimated_departure_time")
    private Timestamp estimatedDepartureTime;
}
