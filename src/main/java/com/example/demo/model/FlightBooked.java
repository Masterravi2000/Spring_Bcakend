package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class FlightBooked {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // User details
    private String firstName;
    private String lastName;
    private String email;

    // Flight details
    private String airline;
    private String flightNumber;
    private String fromCity;
    private String toCity;
    private String departureTime;
    private String arrivalTime;

    private double totalPrice;

    // Seat numbers can be stored as comma-separated string
    private String seatNumbers;
}