package com.flightmanagement.flight_m_app.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.flightmanagement.flight_m_app.enums.FlightStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "flight")
public class flight {
    
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String flightNumber;

    private String origin;
    private String destination;

    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

    private int availableSeats;
    private Double Price;

    @Enumerated(EnumType.STRING)
    private FlightStatus status;




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


    



    @OneToMany(mappedBy = "flight", cascade = CascadeType.PERSIST)
    private List<Booking> bookings = new ArrayList<>();





   
public void setStatus(FlightStatus status) {
    this.status = status;
}
    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

   
   
   
    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }


   

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    
    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
    public flight() {}

}
