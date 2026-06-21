package com.flightmanagement.flight_m_app.Service;

import java.util.List;

import com.flightmanagement.flight_m_app.Dto.Request.CreateFlightRequest;
import com.flightmanagement.flight_m_app.Dto.Request.flightSearchRequest;
import com.flightmanagement.flight_m_app.Dto.Response.flightResponseMapper;
import com.flightmanagement.flight_m_app.Dto.Response.flightSearchResponse;
import com.flightmanagement.flight_m_app.entity.flight;

public interface FlightService {

flight createFlight(CreateFlightRequest request);    
List<flightResponseMapper> getAllFlights();
List<flightSearchResponse> searchFlights(flightSearchRequest request);

}
