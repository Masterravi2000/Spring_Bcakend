package com.example.demo.controller;

import com.example.demo.dto.BookFlightRequest;
import com.example.demo.model.FlightBooked;
import com.example.demo.service.FlightBookedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightBookedController {

    @Autowired
    private FlightBookedService flightService;

    @PostMapping("/book")
    public String bookFlight(@RequestBody BookFlightRequest req) {
        return flightService.bookFlight(req);
    }

    @GetMapping("/my-flights")
    public List<FlightBooked> getMyFlights(@RequestParam String email) {
        return flightService.getFlightsByEmail(email);
    }
}