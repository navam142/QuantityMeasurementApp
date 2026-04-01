package com.apps.quantitymeasurement.uc15.unit;

public enum LengthUnit implements IMeasurable{
    FEET(1.0),
    INCHES(1.0 / 12);

    private final double factor;

    LengthUnit(double factor) {
        this.factor = factor;
    }

    public double toBase(double value) {
        return value * factor;
    }

    public double fromBase(double baseValue) {
        return baseValue / factor;
    }

    @Override
    public String getMeasurementType() {
        return "length";
    }
}
