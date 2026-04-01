package com.apps.quantitymeasurement.uc15.unit;

public enum TemperatureUnit implements IMeasurable{
    CELSIUS {
        public double toBase(double value) { return value; }
        public double fromBase(double value) { return value; }
    },

    FAHRENHEIT {
        public double toBase(double value) { return (value - 32) * 5 / 9; }
        public double fromBase(double value) { return (value * 9 / 5) + 32; }
    };

    @Override
    public boolean supportsArithmetic() {
        return false;
    }

    @Override
    public void validateOperationSupport(String operation) {
        throw new UnsupportedOperationException("Temperature does not support " + operation);
    }

    public String getMeasurementType() {
        return "temperature";
    }
}
