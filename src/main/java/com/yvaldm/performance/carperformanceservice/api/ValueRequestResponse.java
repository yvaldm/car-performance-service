package com.yvaldm.performance.carperformanceservice.api;

import java.math.BigDecimal;

/**
 * Class holding value with measurement unit
 *
 * @author valeryyakovlev
 */
public class ValueRequestResponse {

    private String unit;
    private BigDecimal value;

    public ValueRequestResponse() {
    }

    public ValueRequestResponse(String unit, BigDecimal value) {
        this.unit = unit;
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public BigDecimal getValue() {
        return value;
    }
}
