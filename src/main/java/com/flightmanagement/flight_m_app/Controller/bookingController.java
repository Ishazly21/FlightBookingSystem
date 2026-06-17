package com.flightmanagement.flight_m_app.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightmanagement.flight_m_app.Dto.Request.bookingRequest;
import com.flightmanagement.flight_m_app.Dto.Response.bookingResponse;
import com.flightmanagement.flight_m_app.Service.BookingService;

@RestController
@RequestMapping("/booking")
public class bookingController {

    private final BookingService bookingService;

    public bookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/create")
    public ResponseEntity<bookingResponse> createBooking(@RequestBody bookingRequest request){

        bookingResponse response = bookingService.createBooking(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
}
