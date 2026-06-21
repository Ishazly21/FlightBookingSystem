package com.flightmanagement.flight_m_app.Service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.flightmanagement.flight_m_app.Dto.Request.LoginRequest;
import com.flightmanagement.flight_m_app.Dto.Request.SignUpRequest;
import com.flightmanagement.flight_m_app.Dto.Response.LoginResponse;
import com.flightmanagement.flight_m_app.Dto.Response.SignUpResponse;
import com.flightmanagement.flight_m_app.Repository.UserRepository;
import com.flightmanagement.flight_m_app.Role.Role;
import com.flightmanagement.flight_m_app.Security.JwtService;
import com.flightmanagement.flight_m_app.Service.AuthService;
import com.flightmanagement.flight_m_app.entity.User;


@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }
    
    @Override
    public SignUpResponse signup(SignUpRequest request) {


        if (userRepository.existsByEmail(request.getEmail())) {
        throw new RuntimeException("Email already exists");
        }
        
        User user = new User();
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));        
        user.setRole(Role.USER);



        // 3. save user
        User savedUser = userRepository.save(user);

        SignUpResponse response = new SignUpResponse();
        response.setId(savedUser.getId());
        response.setFullName(savedUser.getFullName());
        response.setEmail(savedUser.getEmail());
        response.setRole(savedUser.getRole());
        System.out.println("ENCODED PASSWORD: " + user.getPassword());

        return response;

    }


    @Override
    public LoginResponse Login (LoginRequest request){

        User user = userRepository.findByEmail(request.getEmail())
            .orElseThrow(() ->
                new RuntimeException("User not found"));


        System.out.println("REQUEST EMAIL: [" + request.getEmail() + "]");
        System.out.println("REQUEST PASSWORD: [" + request.getPassword() + "]");
        System.out.println("DB PASSWORD: [" + user.getPassword() + "]");
        System.out.println("ENCODER CLASS: " + passwordEncoder.getClass());
        System.out.println("MATCH RESULT: " +
        passwordEncoder.matches(request.getPassword(), user.getPassword()));  

                boolean matches = passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        );

        if (!matches) {
            throw new RuntimeException("Invalid credentials");
        }

       

         String token = jwtService.generateToken(user.getId());
            // Build response
        return new LoginResponse(
        "Login successful",
        user.getEmail(),
        token);
    }


    }





