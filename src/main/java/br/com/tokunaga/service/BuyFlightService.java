package br.com.tokunaga.service;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BuyFlightService {
    private final FlightSearchService service;

    @RateLimiter(name = "basic")
    public List<Flight> searchFlights(String country) throws InterruptedException {
        System.out.println("Here:" + LocalDateTime.now());

        Thread.sleep(1000);

        return service.searchFlightsThrowingException(country);
    }
}
