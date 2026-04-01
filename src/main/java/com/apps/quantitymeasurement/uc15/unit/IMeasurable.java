package com.apps.quantitymeasurement.uc15.unit;

public interface IMeasurable {
    double toBase(double value);
    double fromBase(double baseValue);

    default boolean supportsArithmetic() {
        return true;
    }

    default void validateOperationSupport(String operation) {
        if (!supportsArithmetic()) {
            throw new UnsupportedOperationException("Operation " + operation + " not supported");
        }
    }

    String getMeasurementType();
}
