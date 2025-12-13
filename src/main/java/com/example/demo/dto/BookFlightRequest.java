package com.example.demo.dto;

import lombok.Data;
import java.util.List;

@Data
public class BookFlightRequest {
    private String firstName;
    private String lastName;
    private String email;

    private String airline;
    private String flightNumber;
    private String fromCity;
    private String toCity;
    private String departureTime;
    private String arrivalTime;
    private double totalPrice;

    private List<Integer> seatNumbers; // Frontend sends array
}