package com.example.demo.repository;

import com.example.demo.model.FlightBooked;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightBookedRepository extends JpaRepository<FlightBooked, Long> {
}