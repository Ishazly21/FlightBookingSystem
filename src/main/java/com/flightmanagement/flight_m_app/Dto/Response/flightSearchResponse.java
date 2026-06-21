package com.flightmanagement.flight_m_app.Dto.Response;

import java.time.LocalDateTime;

import com.flightmanagement.flight_m_app.enums.FlightStatus;


    public class flightSearchResponse {

    
        private Long flightId;
        private String flightNumber;

        private String origin;
        private String destination;

        private LocalDateTime departureTime;
        private LocalDateTime arrivalTime;

        private int availableSeats;
        private Double Price;

        private FlightStatus status;



        public flightSearchResponse(Long flightId, String flightNumber, String origin, String destination,
                LocalDateTime departureTime, LocalDateTime arrivalTime, int availableSeats, Double price,
                FlightStatus status) {

            this.flightId = flightId;
            this.flightNumber = flightNumber;
            this.origin = origin;
            this.destination = destination;
            this.departureTime = departureTime;
            this.arrivalTime = arrivalTime;
            this.availableSeats = availableSeats;
            this.Price = price;
            this.status = status;
        }





        public Long getFlightId() {
            return flightId;
        }

        public String getFlightNumber() {
            return flightNumber;
        }

        public String getOrigin() {
            return origin;
        }

        public String getDestination() {
            return destination;
        }

        public LocalDateTime getDepartureTime() {
            return departureTime;
        }

        public LocalDateTime getArrivalTime() {
            return arrivalTime;
        }

        public int getAvailableSeats() {
            return availableSeats;
        }

        public Double getPrice() {
            return Price;
        }

        public FlightStatus getStatus() {
            return status;
        }

        

}

