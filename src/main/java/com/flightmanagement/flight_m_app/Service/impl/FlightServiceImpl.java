package com.flightmanagement.flight_m_app.Service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flightmanagement.flight_m_app.Dto.Request.CreateFlightRequest;
import com.flightmanagement.flight_m_app.Repository.FlightRepository;
import com.flightmanagement.flight_m_app.Service.FlightService;
import com.flightmanagement.flight_m_app.entity.flight;
import com.flightmanagement.flight_m_app.enums.FlightStatus;

@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

    public FlightServiceImpl (FlightRepository flightRepository){

        this.flightRepository=flightRepository;
    }
    

    @Override
    public flight createFlight(CreateFlightRequest request) {

        flight flight = new flight();
        flight.setFlightNumber(request.getFlightNumber());
        flight.setArrivalTime(request.getArrivalTime());
        flight.setOrigin(request.getOrigin());
        flight.setDestination(request.getDestination());
        flight.setDepartureTime(request.getDepartureTime());
        flight.setPrice(request.getPrice());
        flight.setAvailableSeats(request.getAvailableSeats());
        flight.setStatus(FlightStatus.ACTIVE);



        return flightRepository.save(flight);


       }

    @Override
    public List<flight> getAllFlights() {
      
      return flightRepository.findAll();
    }
    
}
