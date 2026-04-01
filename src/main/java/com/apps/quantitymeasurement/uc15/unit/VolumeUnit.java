package com.apps.quantitymeasurement.uc15.unit;

public enum VolumeUnit implements IMeasurable{
    LITRE(1.0),
    MILLILITRE(1.0 / 1000);

    private final double factor;

    VolumeUnit(double factor) {
        this.factor = factor;
    }

    public double toBase(double value) {
        return value * factor;
    }

    public double fromBase(double baseValue) {
        return baseValue / factor;
    }

    public String getMeasurementType() {
        return "volume";
    }
}
