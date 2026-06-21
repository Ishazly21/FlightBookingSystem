package com.flightmanagement.flight_m_app.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.flightmanagement.flight_m_app.Service.UserService;
import com.flightmanagement.flight_m_app.entity.User;
import com.flightmanagement.flight_m_app.Dto.Response.SignUpResponse;
import com.flightmanagement.flight_m_app.Repository.UserRepository;
import com.flightmanagement.flight_m_app.Dto.Request.SignUpRequest;
import com.flightmanagement.flight_m_app.Service.impl.UserServiceImpl;;;

@RestController
@RequestMapping("/admin")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    


@GetMapping("/users")
public ResponseEntity<List<User>> getAllUsers() {
    System.out.println("api is working");
    return ResponseEntity.ok(userService.getAllUsers());
}

}
