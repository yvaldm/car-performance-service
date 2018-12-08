package com.yvaldm.performance.carperformanceservice.api;

import java.math.BigDecimal;

/**
 * Track request/response
 *
 * @author valeryyakovlev
 */
public class TrackRequest {

    private long id;
    private String name;
    private String description;
    private BigDecimal length;
    private String unit;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getLength() {
        return length;
    }

    public String getUnit() {
        return unit;
    }
}
