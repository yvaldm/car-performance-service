package com.yvaldm.performance.carperformanceservice.entity;

import java.math.BigDecimal;

/**
 * Class representing some value with some measurement unit
 *
 * @author valeryyakovlev
 */
public class Value {

    private BigDecimal value;
    private String unit;

    public Value(BigDecimal value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public BigDecimal getValue() {
        return value;
    }

    public String getUnit() {
        return unit;
    }
}
