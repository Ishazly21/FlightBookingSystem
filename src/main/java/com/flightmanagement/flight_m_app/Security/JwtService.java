package com.flightmanagement.flight_m_app.Security;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtService {

private final String SECRET_KEY = "mySecretKey123456mySecretKey123456"; // must be long enough
private Key getSigningKey() {
    return Keys.hmacShaKeyFor
    (SECRET_KEY.getBytes(StandardCharsets.UTF_8));
}


    // Generate token with userId
    public String generateToken(Long userId) {
        return Jwts.builder()
                .setSubject(String.valueOf(userId))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // Extract userId
    public Long extractUserId(String token) {
        String subject = getClaims(token).getSubject();
        return Long.parseLong(subject);
    }

    // Validate token
    public boolean isTokenValid(String token, Long userId) {
        return extractUserId(token).equals(userId) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }

    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
        .setSigningKey(getSigningKey())
        .build()
        .parseClaimsJws(token)
        .getBody();
    }
}
