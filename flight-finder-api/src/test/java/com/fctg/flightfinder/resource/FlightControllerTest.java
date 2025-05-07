package com.fctg.flightfinder.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fctg.flightfinder.dto.FlightRequest;
import com.fctg.flightfinder.service.FlightService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FlightController.class)
public class FlightControllerTest {

    @MockBean
    private FlightService flightService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void searchFlightsValidInput() throws Exception {

        FlightRequest request = new FlightRequest();
        request.setInputKeyword("flightflight");

        when(flightService.findFlightWordOccurrences("flightflight")).thenReturn(2);

        mockMvc.perform(post("/api/flights/search")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.count").value(2));

        verify(flightService, times(1)).findFlightWordOccurrences("flightflight");
    }

    @Test
    public void searchFlightsInValidInput() throws Exception {

        FlightRequest request = new FlightRequest();
        request.setInputKeyword("ab");

        mockMvc.perform(post("/api/flights/search")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.inputKeyword").value("Input should have at least 3 characters."));
    }
}
