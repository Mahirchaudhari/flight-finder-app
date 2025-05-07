package com.fctg.flightfinder.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class FlightServiceTest {

    @Autowired
    private FlightService flightService;

    @Test
    void testFindFlightWordOccurrencesForValidInput() {
        assertEquals(1, flightService.findFlightWordOccurrences("flight"));
    }

    @Test
    void testFindFlightWordOccurrencesForMultipleOccurrences() {
        assertEquals(2, flightService.findFlightWordOccurrences("flight tfligh"));
    }

    @Test
    void testFindFlightWordOccurrencesForNoOccurrences() {
        assertEquals(0, flightService.findFlightWordOccurrences("hello world"));
    }
}
