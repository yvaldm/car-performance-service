package com.yvaldm.performance.carperformanceservice.entity;

import com.yvaldm.performance.carperformanceservice.api.ArtificialIntelligence;
import com.yvaldm.performance.carperformanceservice.api.Transmission;

public class Car {

    private long id;
    private String code;
    private Transmission transmission;
    private ArtificialIntelligence ai;
    private Value maxSpeed;

    public Car(long id, String code, Transmission transmission,
               ArtificialIntelligence ai, Value maxSpeed) {
        this.id = id;
        this.code = code;
        this.transmission = transmission;
        this.ai = ai;
        this.maxSpeed = maxSpeed;
    }

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

    public Value getMaxSpeed() {
        return maxSpeed;
    }
}
