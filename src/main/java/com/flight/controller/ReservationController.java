package com.flight.controller;

import com.flight.entities.Reservation;
import com.flight.service.FlightService;
import com.flight.service.PassengerService;
import com.flight.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {
    @Autowired
    FlightService flightService;

    @Autowired
    ReservationService reservationService;

    @Autowired
    PassengerService passengerService;

    //user privilage
    @PostMapping
    public Optional<Reservation> addReservation(@RequestBody Reservation reservation) {
        var flight = reservation.getFlight();
        return flightService.findFlightByFlightNumber(flight.getFlightNumber())
                .map(availableFlight -> {
                    passengerService.addPassenger(reservation.getPassenger());
                    reservation.setFlight(availableFlight);
                    return reservationService.addReservation(reservation);
                });
    }

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.getReservations();
    }
}
