package com.flightmanagement.flight_m_app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightmanagement.flight_m_app.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long>{}
