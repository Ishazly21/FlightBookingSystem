package com.flightmanagement.flight_m_app.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightmanagement.flight_m_app.Dto.Request.LoginRequest;
import com.flightmanagement.flight_m_app.Dto.Request.SignUpRequest;
import com.flightmanagement.flight_m_app.Dto.Response.LoginResponse;
import com.flightmanagement.flight_m_app.Dto.Response.SignUpResponse;
import com.flightmanagement.flight_m_app.Service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

private final AuthService authService;

public AuthController(AuthService authService) {
    this.authService = authService;
}


    @PostMapping("/signup")
    public SignUpResponse signup(@RequestBody SignUpRequest request) {
        System.out.println("SIGNUP HIT");
        return authService.signup(request);
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> Login(@RequestBody LoginRequest request) 
    {
        System.out.println("login hit");
        LoginResponse response = authService.Login(request);

        return ResponseEntity.ok(response);
    }







}
