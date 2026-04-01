package com.apps.quantitymeasurement.uc15.entity;

public class QuantityMeasurementEntity {
    private String operation;
    private String result;
    private boolean isError;

    public QuantityMeasurementEntity(String operation, String result) {
        this.operation = operation;
        this.result = result;
        this.isError = false;
    }

    public QuantityMeasurementEntity(String error) {
        this.result = error;
        this.isError = true;
    }

    public boolean isError() { return isError; }

    @Override
    public String toString() {
        return isError ? "Error: " + result : operation + " => " + result;
    }
}
