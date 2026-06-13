package com.flightmanagement.flight_m_app.Service;
import java.util.List;

import com.flightmanagement.flight_m_app.Dto.Request.SignUpRequest;
import com.flightmanagement.flight_m_app.Dto.Response.SignUpResponse;
import com.flightmanagement.flight_m_app.entity.User;

public interface UserService {
    SignUpResponse signup(SignUpRequest request);
    List<User> getAllUsers();
    /*Boolean LogIn(String email , String password);*/
    
}
