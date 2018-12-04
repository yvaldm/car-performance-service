package com.yvaldm.performance.carperformanceservice.api;

import java.math.BigDecimal;

public class MeasurementRequestResponse {

    private String unit;
    private BigDecimal value;

    public String getUnit() {
        return unit;
    }

    public BigDecimal getValue() {
        return value;
    }
}
