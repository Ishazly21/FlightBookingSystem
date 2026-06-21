package com.flightmanagement.flight_m_app.Specification;

import org.springframework.data.jpa.domain.Specification;

import com.flightmanagement.flight_m_app.entity.flight;

public class flightSpecification {


     public static Specification<flight> hasOrigin(String origin) {
        return (root, query, cb) ->
                origin == null ? null :
                        cb.equal(root.get("origin"), origin);
    }

    public static Specification<flight> hasDestination(String destination) {
        return (root, query, cb) ->
                destination == null ? null :
                        cb.equal(root.get("destination"), destination);
    }

    public static Specification<flight> hasAvailableSeats(Integer minSeats) {
        return (root, query, cb) ->
                minSeats == null ? null :
                        cb.greaterThanOrEqualTo(root.get("availableSeats"), minSeats);
    }

    
    
}
