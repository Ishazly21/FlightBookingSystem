package com.flightmanagement.flight_m_app.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
@Table(name = "bookings")
public class Booking {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status; // CONFIRMED, CANCELLED
    private LocalDateTime bookingDate;
    private String Booking_reference;

public String getBooking_reference() {
        return Booking_reference;
    }

    public void setBooking_reference(String booking_reference) {
        Booking_reference = booking_reference;
    }


@ManyToOne
    @JoinColumn(name = "flight_id")
    private flight flight;

@ManyToOne
    @JoinColumn(name = "User_id")
    private User user;


public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

public Booking() {}

    
}
