package br.com.tokunaga.service;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FlightSearchService {

    public List<Flight> searchFlightsThrowingException(String country) {
        throw new RuntimeException("Error");
    }
}
