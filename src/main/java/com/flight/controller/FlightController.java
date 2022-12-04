package com.flight.controller;

import com.flight.entities.Flight;
import com.flight.exceptions.FlightNotFoundException;
import com.flight.service.FlightService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {
    @Autowired
    FlightService flightService;

    //admin
    @PostMapping
    public ResponseEntity<Flight> addFlight(@Valid @RequestBody Flight flight) {
        var savedFlight = flightService.addFlight(flight);
        var uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(savedFlight.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public List<Flight> getFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping("/{id}")
    public Flight getFlightById(@PathVariable("id") Long id) {
        System.out.println("id " + id);
        return flightService
                .getFlight(id)
                .orElseThrow(() -> new FlightNotFoundException("Flight Not Found"));
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
