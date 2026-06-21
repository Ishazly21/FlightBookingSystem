package com.flightmanagement.flight_m_app.Controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightmanagement.flight_m_app.Dto.Request.CreateFlightRequest;
import com.flightmanagement.flight_m_app.Dto.Request.flightSearchRequest;
import com.flightmanagement.flight_m_app.Dto.Response.flightResponseMapper;
import com.flightmanagement.flight_m_app.Dto.Response.flightSearchResponse;
import com.flightmanagement.flight_m_app.Service.FlightService;
import com.flightmanagement.flight_m_app.entity.flight;

@RestController
@RequestMapping("/flights")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;

    }

    @PostMapping("/create")
    public ResponseEntity<flight> createFlight(@RequestBody CreateFlightRequest request)
    {
        System.out.println("create hit !!!*(*((****");
        return ResponseEntity.status(HttpStatus.CREATED).body(flightService.createFlight(request));
    }

     @GetMapping("/all")
    public ResponseEntity<List<flightResponseMapper>> getAllFlights() {
        return ResponseEntity.ok(flightService.getAllFlights());
    }

        @GetMapping("/search")
public ResponseEntity<List<flightSearchResponse>> searchFlights(@RequestBody flightSearchRequest request)
 {
    return ResponseEntity.ok(
            flightService.searchFlights(request)
    );
}

}
