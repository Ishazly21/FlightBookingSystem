package com.flightmanagement.flight_m_app.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.flightmanagement.flight_m_app.entity.Passenger;



@Service
public interface PassengerService {

    
    Passenger register(Passenger paassenger);
    /*Passenger Login(passenger.getName)*/

    Passenger getUserById(Long id);
    List<Passenger> getallpPassengers();


    
}
