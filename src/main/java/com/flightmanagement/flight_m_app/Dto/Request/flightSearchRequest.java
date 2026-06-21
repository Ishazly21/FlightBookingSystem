package com.flightmanagement.flight_m_app.Dto.Request;

import java.time.LocalDate;

public class flightSearchRequest {

    private String origin;
    private String destination;
    private LocalDate date;
    private int minSeats;




    public String getOrigin() {
        return origin;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public int getMinSeats() {
        return minSeats;
    }
    public void setMinSeats(Integer minSeats) {
        this.minSeats = minSeats;
    }

    
}
