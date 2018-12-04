package com.yvaldm.performance.carperformanceservice.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CarRequestResponse {

    private long id;
    private String code;
    private Transmission transmission;
    private ArtificialIntelligence ai;

    @JsonProperty("max-speed")
    private MeasurementRequestResponse maxSpeed;

    public long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public ArtificialIntelligence getAi() {
        return ai;
    }

    public MeasurementRequestResponse getMaxSpeed() {
        return maxSpeed;
    }
}
