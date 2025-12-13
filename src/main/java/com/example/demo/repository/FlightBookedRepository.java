package com.example.demo.repository;

import com.example.demo.model.FlightBooked;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FlightBookedRepository extends JpaRepository<FlightBooked, Long> {
    List<FlightBooked> findByEmail(String email);
}