package com.flightmanagement.flight_m_app.Service.impl;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.security.core.Authentication;
import com.flightmanagement.flight_m_app.Dto.Request.bookingRequest;
import com.flightmanagement.flight_m_app.Dto.Response.bookingResponse;
import com.flightmanagement.flight_m_app.Repository.BookingRepository;
import com.flightmanagement.flight_m_app.Repository.FlightRepository;
import com.flightmanagement.flight_m_app.Service.BookingService;
import com.flightmanagement.flight_m_app.entity.Booking;
import com.flightmanagement.flight_m_app.entity.User;
import com.flightmanagement.flight_m_app.entity.flight;


@Service
public class bookingServiceImpl implements BookingService {



    private final BookingRepository BookingRepository;
    private final FlightRepository flightRepository;

    public bookingServiceImpl(BookingRepository BookingRepository,FlightRepository flightRepository){

        this.BookingRepository=BookingRepository;
        this.flightRepository = flightRepository;

    }
   
   
    @Override
    public bookingResponse createBooking( bookingRequest request) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

            User user = (User) auth.getPrincipal();

            flight flight = flightRepository.findById(request.getFlightId())
            .orElseThrow(() -> new RuntimeException("Flight not found"));

    if (flight.getAvailableSeats() <= 0) {
        throw new RuntimeException("No seats available");
    }

    flight.setAvailableSeats(flight.getAvailableSeats() - 1);
    flightRepository.save(flight);

    String ref = generateReference();

    Booking booking = new Booking();
    booking.setUser(user);
    booking.setFlight(flight);
    booking.setBookingDate(LocalDateTime.now());
    booking.setBooking_reference(ref);

    // saving booking
    BookingRepository.save(booking);

    

    return new bookingResponse(
            booking.getId(),
            "Booking successful",
            flight.getId(),
            flight.getFlightNumber(),
            booking.getBookingDate()
        );


    }
 
    private String generateReference() {
    return "BK-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();

}

}
