package com.flightmanagement.flight_m_app.Service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flightmanagement.flight_m_app.Repository.UserRepository;
import com.flightmanagement.flight_m_app.Service.UserService;
import com.flightmanagement.flight_m_app.entity.User;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository UserRepository;

    public UserServiceImpl(UserRepository UserRepository) {
        this.UserRepository = UserRepository;
    }

    


    @Override
public List<User> getAllUsers() {
    return UserRepository.findAll();
}

    
}
