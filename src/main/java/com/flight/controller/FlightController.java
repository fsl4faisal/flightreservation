package com.flight.controller;

import com.flight.entities.Flight;
import com.flight.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {
    @Autowired
    FlightService flightService;

    //admin
    @PostMapping
    public Flight addFlight(@RequestBody Flight flight) {
        return flightService.addFlight(flight);
    }

    @GetMapping
    public List<Flight> getFlights() {
        return flightService.getAllFlights();
    }


    @GetMapping("/find")
    public List<Flight> findFlights(
            @RequestParam("arrivalCity") String arrivalCity,
            @RequestParam("departureCity") String departureCity,
            @RequestParam("departureDate")
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date departureDate) {
        return flightService.findFlights(arrivalCity, departureCity, departureDate);
    }
}
