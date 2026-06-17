package com.flightmanagement.flight_m_app.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.flightmanagement.flight_m_app.Security.JwtAuthFilter;


@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() 
    {
        return new BCryptPasswordEncoder();

    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtAuthFilter jwtAuthFilter) throws Exception {

            System.out.println("🔥 SECURITY CONFIG ACTIVE");

        http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/auth/**").permitAll()
            .requestMatchers("/flights/**").permitAll()
            .requestMatchers("/bookings/**").hasRole("USER")
            .requestMatchers("/flights/create").hasRole("ADMIN")
            .requestMatchers("/flights/delete/**").hasRole("ADMIN")
            .anyRequest().authenticated()
        )

        .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
    return http.build();
}
}
