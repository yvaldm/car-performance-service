package com.yvaldm.performance.carperformanceservice.api;

import java.math.BigDecimal;

/**
 * Class holding value with measurement unit
 *
 * @author valeryyakovlev
 */
public class ValueRequestResponse {

    private BigDecimal value;
    private String unit;

    public ValueRequestResponse() {
    }

    public ValueRequestResponse(BigDecimal value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }

    public BigDecimal getValue() {
        return value;
    }
}
