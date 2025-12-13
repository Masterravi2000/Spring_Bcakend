package com.example.demo.service;

import com.example.demo.dto.BookFlightRequest;
import com.example.demo.model.FlightBooked;
import com.example.demo.repository.FlightBookedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FlightBookedService {

    @Autowired
    private FlightBookedRepository flightRepo;

    public String bookFlight(BookFlightRequest req) {
        try {
            FlightBooked flight = new FlightBooked();
            flight.setFirstName(req.getFirstName());
            flight.setLastName(req.getLastName());
            flight.setEmail(req.getEmail());
            flight.setAirline(req.getAirline());
            flight.setFlightNumber(req.getFlightNumber());
            flight.setFromCity(req.getFromCity());
            flight.setToCity(req.getToCity());
            flight.setDepartureTime(req.getDepartureTime());
            flight.setArrivalTime(req.getArrivalTime());
            flight.setTotalPrice(req.getTotalPrice());

            // convert seatNumbers array to comma-separated string
            flight.setSeatNumbers(String.join(",", req.getSeatNumbers().stream()
                    .map(String::valueOf).toArray(String[]::new)));

            flightRepo.save(flight);
            return "Flight booked successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Flight booking failed";
        }
    }

    public List<FlightBooked> getFlightsByEmail(String email) {
        return flightRepo.findByEmail(email);
    }
}
