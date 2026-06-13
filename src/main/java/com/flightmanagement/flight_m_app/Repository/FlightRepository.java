package com.flightmanagement.flight_m_app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightmanagement.flight_m_app.entity.flight;
@Repository
public interface FlightRepository extends JpaRepository<flight, Long>{}

