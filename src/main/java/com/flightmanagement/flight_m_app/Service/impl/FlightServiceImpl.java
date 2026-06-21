package com.flightmanagement.flight_m_app.Service.impl;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.flightmanagement.flight_m_app.Dto.Request.CreateFlightRequest;
import com.flightmanagement.flight_m_app.Dto.Request.flightSearchRequest;
import com.flightmanagement.flight_m_app.Dto.Response.bookingResponse;
import com.flightmanagement.flight_m_app.Dto.Response.flightResponseMapper;
import com.flightmanagement.flight_m_app.Dto.Response.flightSearchResponse;
import com.flightmanagement.flight_m_app.Repository.FlightRepository;
import com.flightmanagement.flight_m_app.Role.Role;
import com.flightmanagement.flight_m_app.Service.FlightService;
import com.flightmanagement.flight_m_app.Specification.flightSpecification;
import com.flightmanagement.flight_m_app.entity.User;
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
    public List<flightResponseMapper> getAllFlights() {

    Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        // check auth for debugging
        System.out.println(auth);
        System.out.println(auth.getAuthorities());

    User user = (User) auth.getPrincipal();

    boolean isAdmin = user.getRole() == Role.ADMIN;

    List<flight> flights = flightRepository.findAll();

    return flights.stream()
            .map(f -> {

                flightResponseMapper dto = new flightResponseMapper();

                dto.setId(f.getId());
                dto.setFlightNumber(f.getFlightNumber());
                dto.setOrigin(f.getOrigin());
                dto.setDestination(f.getDestination());
                dto.setDepartureTime(f.getDepartureTime());
                dto.setArrivalTime(f.getArrivalTime());
                dto.setAvailableSeats(f.getAvailableSeats());
                dto.setPrice(f.getPrice());
                dto.setStatus(f.getStatus());

                // 🔥 ROLE-BASED LOGIC
                if (isAdmin) {
                    dto.setBookings(
                        f.getBookings().stream()
                            .map(b -> new bookingResponse(b.getId(),b.getStatus(), //  enum directly
                                b.getFlight().getId(),
                                b.getFlight().getFlightNumber(),
                                b.getBookingDate()))

                            .toList()
                    );
                } else {
                    dto.setBookings(null); // or omit entirely
                }

                return dto;
            })
            .toList();
}
    

     @Override
    public List<flightSearchResponse> searchFlights(flightSearchRequest request) {

        Specification<flight> spec = 
                (flightSpecification.hasOrigin(request.getOrigin()))
                .and(flightSpecification.hasDestination(request.getDestination()))
                .and(flightSpecification.hasAvailableSeats(request.getMinSeats()));

        List<flight> flights = flightRepository.findAll(spec);

        return flights.stream()
                .map(f -> new flightSearchResponse(
                f.getId(),
                f.getFlightNumber(),
                f.getOrigin(),
                f.getDestination(),
                f.getDepartureTime(),
                f.getArrivalTime(),
                f.getAvailableSeats(),
                f.getPrice(),
                f.getStatus()
                ))
                .toList();
    }


}
