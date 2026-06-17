package com.flightmanagement.flight_m_app.Dto.Response;

import java.time.LocalDateTime;

public class bookingResponse {
    
    private Long bookingId;
    private String message;
    private Long flight_id;
    private String flightNumber;
    private LocalDateTime bookingDate;

    

    public bookingResponse(Long bookingId, String message, Long flightId, String flightNumber,LocalDateTime bookingDate) {
        this.bookingId = bookingId;
        this.message = message;
        this.flight_id = flightId;
        this.flightNumber = flightNumber;
        this.bookingDate=bookingDate;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public String getMessage() {
        return message;
    }

    public Long getFlightId() {
        return flight_id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }
    
    public LocalDateTime getBookingDate() {
        return bookingDate;
    }


}
