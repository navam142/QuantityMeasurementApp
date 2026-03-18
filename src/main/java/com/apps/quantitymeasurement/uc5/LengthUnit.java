package com.apps.quantitymeasurement.uc5;

public enum LengthUnit{
    INCHES(1.0),
    FEET(12.0),
    YARDS(36.0),
    CENTIMETERS(0.393701);
    private final double toInchesFactor;
    LengthUnit(double toInchesFactor){
        this.toInchesFactor=toInchesFactor;
    }
    public double toInches(double value){
        return value*toInchesFactor;
    }
    public double fromInches(double inches){
        return inches/toInchesFactor;
    }
}
