package com.flightmanagement.flight_m_app.Service;

import com.flightmanagement.flight_m_app.Dto.Request.LoginRequest;
import com.flightmanagement.flight_m_app.Dto.Request.SignUpRequest;
import com.flightmanagement.flight_m_app.Dto.Response.LoginResponse;
import com.flightmanagement.flight_m_app.Dto.Response.SignUpResponse;

public interface AuthService {

    SignUpResponse signup(SignUpRequest request);
    LoginResponse Login(LoginRequest request);

    
}
