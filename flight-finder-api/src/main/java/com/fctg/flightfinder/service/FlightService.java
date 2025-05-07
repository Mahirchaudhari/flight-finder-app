package com.fctg.flightfinder.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FlightService {

    private static final Logger logger = LoggerFactory.getLogger(FlightService.class);

    /**
     * This method counts the occurrences of the word "flight" in the given input string.
     *
     * @param inputKeyword The input string to search within.
     * @return The number of occurrences of the word "flight" in the input string.
     */
    public int findFlightWordOccurrences(String inputKeyword) {
        logger.info("Finding occurrences of keyword " +  inputKeyword);

        char[] required = "flight".toCharArray();
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char c : inputKeyword.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        int count = Integer.MAX_VALUE;
        for (char c : required) {
            count = Math.min(count, frequencyMap.getOrDefault(c, 0));
        }

        logger.info("Occurrences of word 'flight' in input "+ inputKeyword + " : "+ count);

        return count;
    }

}
