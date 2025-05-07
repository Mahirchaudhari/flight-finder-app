package com.fctg.flightfinder.resource;

import com.fctg.flightfinder.dto.FlightRequest;
import com.fctg.flightfinder.service.FlightService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000"})
@RequestMapping("/api/flights")
public class FlightController {

    private FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    /**
     * Endpoint to search for the number of occurrences of a flight word in a given input string.
     *
     * @param flightRequest The input string to search within.
     * @return The number of occurrences of the word in the input string.
     */
    @PostMapping("/search")
    public ResponseEntity<?> searchFlights(@Valid
                                           @RequestBody FlightRequest flightRequest) {
        logger.info("Searching for occurrences of word '{}' in input '{}'", flightRequest);

        String input = flightRequest.getInputKeyword().toLowerCase();
        int count = flightService.findFlightWordOccurrences(input);
        return ResponseEntity.ok(Map.of("count", count));
    }

    private static final Logger logger = LoggerFactory.getLogger(FlightController.class);

}
