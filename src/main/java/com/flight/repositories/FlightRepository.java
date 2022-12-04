package com.flight.repositories;

import com.flight.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query("from Flight where arrivalCity=:arrivalCity AND departureCity=:departureCity AND dateOfDeparture=:departureDate")
    List<Flight> findFlights(
            @Param("arrivalCity") String arrivalCity,
            @Param("departureCity") String departureCity,
            @Param("departureDate") Date departureDate);

    Optional<Flight> findFlightByFlightNumber(String flightNumber);
}
