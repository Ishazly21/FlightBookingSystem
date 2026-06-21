package com.flightmanagement.flight_m_app.Security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.flightmanagement.flight_m_app.Repository.UserRepository;
import com.flightmanagement.flight_m_app.entity.User;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component
public class JwtAuthFilter extends OncePerRequestFilter {


     private final JwtService jwtService;
    private final UserRepository userRepository;

public JwtAuthFilter(JwtService jwtService, UserRepository userRepository) {
        this.jwtService = jwtService;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
                
                        System.out.println("🔥 JWT FILTER HIT");

        String authHeader = request.getHeader("Authorization");
        System.out.println("HEADER = " + authHeader);

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = authHeader.substring(7);

        Long userId = Long.valueOf(jwtService.extractUserId(token));

        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found")
        );

        if (user != null) {
            
            List<GrantedAuthority> authorities =
            List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()));

            UsernamePasswordAuthenticationToken auth =
            new UsernamePasswordAuthenticationToken(
                    user,
                    null,
                    authorities
                    
            );

            SecurityContextHolder.getContext().setAuthentication(auth);
            System.out.println("AUTH SET = " + auth);
            System.out.println("AUTHORITIES = " + auth.getAuthorities());
        }

            
        filterChain.doFilter(request, response);
    }

    }
    

