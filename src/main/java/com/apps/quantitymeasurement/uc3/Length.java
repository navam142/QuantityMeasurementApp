package com.apps.quantitymeasurement.uc3;

public class Length {

    enum LengthUnit {

        FEET(1.0),
        INCHES(1.0/12);

        private final double conversionFactor;
        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }
        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    private double value;
    private LengthUnit unit;

    public Length(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    private double convertToBaseUnit() {
        return value * this.unit.getConversionFactor();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Length other)) {
            return false;
        }
        double thisValue = this.convertToBaseUnit();
        double otherValue = other.convertToBaseUnit();

        return Math.abs(thisValue - otherValue) < 0.0001;
    }
}
