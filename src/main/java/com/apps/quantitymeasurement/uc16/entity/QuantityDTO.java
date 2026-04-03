package com.apps.quantitymeasurement.uc16.entity;

public class QuantityDTO {

    public interface IMeasurableUnit {
        String getUnitName();
        String getMeasurementType();
    }

    public enum LengthUnit implements IMeasurableUnit {
        FEET, INCHES, YARDS, CENTIMETERS, METERS;
        @Override public String getUnitName() { return this.name(); }
        @Override public String getMeasurementType() { return "LENGTH"; }
    }

    public enum VolumeUnit implements IMeasurableUnit {
        LITER, MILLILITER, GALLON;
        @Override public String getUnitName() { return this.name(); }
        @Override public String getMeasurementType() { return "VOLUME"; }
    }

    public enum WeightUnit implements IMeasurableUnit {
        GRAM, KILOGRAM, POUND, OUNCE;
        @Override public String getUnitName() { return this.name(); }
        @Override public String getMeasurementType() { return "WEIGHT"; }
    }

    public enum TemperatureUnit implements IMeasurableUnit {
        CELSIUS, FAHRENHEIT, KELVIN;
        @Override public String getUnitName() { return this.name(); }
        @Override public String getMeasurementType() { return "TEMPERATURE"; }
    }

    private double value;
    private String unit;
    private String measurementType;

    public QuantityDTO() {}

    public QuantityDTO(double value, IMeasurableUnit unit) {
        this.value = value;
        this.unit = unit.getUnitName();
        this.measurementType = unit.getMeasurementType();
    }

    public QuantityDTO(double value, String unit, String measurementType) {
        this.value = value;
        this.unit = unit;
        this.measurementType = measurementType;
    }

    public double getValue() { return value; }
    public String getUnit() { return unit; }
    public String getMeasurementType() { return measurementType; }

    public void setValue(double value) { this.value = value; }
    public void setUnit(String unit) { this.unit = unit; }
    public void setMeasurementType(String measurementType) { this.measurementType = measurementType; }

    @Override
    public String toString() {
        return "QuantityDTO{" +
                "value=" + value +
                ", unit='" + unit + '\'' +
                ", measurementType='" + measurementType + '\'' +
                '}';
    }
}
