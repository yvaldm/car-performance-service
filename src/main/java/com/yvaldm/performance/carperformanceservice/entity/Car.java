package com.yvaldm.performance.carperformanceservice.entity;

import com.yvaldm.performance.carperformanceservice.api.ArtificialIntelligence;
import com.yvaldm.performance.carperformanceservice.api.Transmission;

/**
 * Car entity
 *
 * @author valeryyakovlev
 */
public class Car {

    private long id;
    private long trackId;
    private String code;
    private Transmission transmission;
    private ArtificialIntelligence ai;
    private Value maxSpeed;

    public Car(long id, long trackId, String code, Transmission transmission,
               ArtificialIntelligence ai, Value maxSpeed) {
        this.id = id;
        this.trackId = trackId;
        this.code = code;
        this.transmission = transmission;
        this.ai = ai;
        this.maxSpeed = maxSpeed;
    }

    public long getId() {
        return id;
    }

    public long getTrackId() {
        return trackId;
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
