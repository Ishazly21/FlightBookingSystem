package com.flightmanagement.flight_m_app.Service;

import java.util.List;

import com.flightmanagement.flight_m_app.Dto.Request.CreateFlightRequest;
import com.flightmanagement.flight_m_app.entity.flight;

public interface FlightService {

flight createFlight(CreateFlightRequest request);    
List<flight> getAllFlights();
}
