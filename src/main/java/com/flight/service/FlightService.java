package com.flight.service;

import com.flight.entities.Flight;
import com.flight.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;


    public List<Flight> findFlights(String arrivalCity, String departureCity, Date departureDate) {
        return flightRepository.findFlights(arrivalCity, departureCity, departureDate);
    }

    public Optional<Flight> findFlightByFlightNumber(String flightNumber) {
        return flightRepository.findFlightByFlightNumber(flightNumber);
    }

    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }
    public Optional<Flight> getFlight(Long id){
        return flightRepository.findById(id);
    }
}
