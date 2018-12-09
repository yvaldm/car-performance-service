package com.yvaldm.performance.carperformanceservice.api;

/**
 * Request/response for car entity
 *
 * @author valeryyakovlev
 */
public class CarRequestResponse {

    private long id;
    private long trackId;
    private String code;
    private Transmission transmission;
    private ArtificialIntelligence ai;
    private ValueRequestResponse maxSpeed;

    public CarRequestResponse() {
    }

    public CarRequestResponse(long id, long trackId, String code, Transmission transmission, ArtificialIntelligence ai, ValueRequestResponse maxSpeed) {
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

    public ValueRequestResponse getMaxSpeed() {
        return maxSpeed;
    }
}
