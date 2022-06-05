package br.com.tokunaga.controller;

import br.com.tokunaga.service.BuyFlightService;
import br.com.tokunaga.service.Flight;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.Objects.isNull;

@RestController
@RequiredArgsConstructor
public class BuyFlightController {
    private final BuyFlightService service;

    @GetMapping("/flight/{country}")
    public ResponseEntity getBuyFlight(@PathVariable String country) throws InterruptedException {
        List<Flight> flights = service.searchFlights(country);
        if (!isNull(flights)) {
            return ResponseEntity.ok(flights);
        }
        return ResponseEntity.noContent().build();
    }
}
