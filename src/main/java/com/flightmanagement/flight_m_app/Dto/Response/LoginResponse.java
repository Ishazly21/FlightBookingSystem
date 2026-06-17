package com.flightmanagement.flight_m_app.Dto.Response;

public class LoginResponse {
    
    private String message;
    private String email;
    private String token;


    public String getToken() {
        return token;
    }

    public LoginResponse(String message, String email,String token) {
        this.message = message;
        this.email = email;
        this.token=token;
    }

    public String getMessage() {
        return message;
    }

    public String getEmail() {
        return email;
    }
}
