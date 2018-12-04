package com.yvaldm.performance.carperformanceservice.entity;

import java.math.BigDecimal;

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
