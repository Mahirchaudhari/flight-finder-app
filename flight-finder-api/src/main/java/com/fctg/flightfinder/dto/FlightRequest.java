package com.fctg.flightfinder.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class FlightRequest {

    @NotBlank(message = "Input cannot be blank.")
    @Size(min = 3, message = "Input should have at least 3 characters.")
    private String inputKeyword;

    public String getInputKeyword() {
        return inputKeyword;
    }

    public void setInputKeyword(String inputKeyword) {
        this.inputKeyword = inputKeyword;
    }
}
