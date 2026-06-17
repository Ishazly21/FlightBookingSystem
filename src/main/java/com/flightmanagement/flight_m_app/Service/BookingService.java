package com.flightmanagement.flight_m_app.Service;

import com.flightmanagement.flight_m_app.Dto.Request.bookingRequest;
import com.flightmanagement.flight_m_app.Dto.Response.bookingResponse;



public interface BookingService {

    bookingResponse createBooking(bookingRequest request);
    
}
