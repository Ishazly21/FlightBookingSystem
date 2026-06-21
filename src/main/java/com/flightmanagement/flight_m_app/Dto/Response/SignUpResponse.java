package com.flightmanagement.flight_m_app.Dto.Response;

import com.flightmanagement.flight_m_app.Role.Role;

public class SignUpResponse {
    private Long id;
    private String fullName;
    private String email;
    private Role role;

    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
}
