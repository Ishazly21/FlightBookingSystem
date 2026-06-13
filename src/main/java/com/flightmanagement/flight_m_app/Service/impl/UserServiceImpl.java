package com.flightmanagement.flight_m_app.Service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flightmanagement.flight_m_app.Dto.Request.SignUpRequest;
import com.flightmanagement.flight_m_app.Dto.Response.SignUpResponse;
import com.flightmanagement.flight_m_app.Repository.UserRepository;
import com.flightmanagement.flight_m_app.Service.UserService;
import com.flightmanagement.flight_m_app.entity.User;
import com.flightmanagement.flight_m_app.Role.*;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository UserRepository;

    public UserServiceImpl(UserRepository UserRepository) {
        this.UserRepository = UserRepository;
    }

    @Override
    public SignUpResponse signup(SignUpRequest request) {
        
        
        if (UserRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        
        User user = new User();
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(Role.USER);



        // 3. save user
        User savedUser = UserRepository.save(user);

        SignUpResponse response = new SignUpResponse();
        response.setId(savedUser.getId());
        response.setFullName(savedUser.getFullName());
        response.setEmail(savedUser.getEmail());
        response.setRole(savedUser.getRole());
        

        return response;


    }

    @Override
public List<User> getAllUsers() {
    return UserRepository.findAll();
}

    
}
