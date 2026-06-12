package com.flightmanagement.flight_m_app.Service.impl;

import org.springframework.stereotype.Service;

import com.flightmanagement.flight_m_app.Service.PassengerService;
import com.flightmanagement.flight_m_app.entity.Passenger;

import java.util.List;

import com.flightmanagement.flight_m_app.Repository.passengerRepository;



@Service
public class PassengerServiceImpl implements PassengerService {

    private final passengerRepository passengerRepository;

    public PassengerServiceImpl(passengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Override
    public Passenger register(Passenger paassenger) {
        // passengerRepository.findById(paassenger.getId());
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'register'");
    }

    @Override
    public Passenger getUserById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserById'");
    }

    @Override
    public List<Passenger> getallpPassengers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getallpPassengers'");
    }

}