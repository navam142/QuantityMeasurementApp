package com.apps.quantitymeasurement.uc15.unit;

public class Quantity<U extends IMeasurable> {
    private double value;
    private U unit;

    public Quantity(double value, U unit) {
        if (unit == null) throw new IllegalArgumentException("Unit cannot be null");
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    private double toBase() {
        return unit.toBase(value);
    }

    public Quantity<U> Quantity(U target) {
        double base = this.toBase();
        double converted = target.fromBase(base);
        return new Quantity<>(converted, target);
    }

    public Quantity<U> add(Quantity<U> other) {
        unit.validateOperationSupport("ADD");
        double result = this.toBase() + other.toBase();
        return new Quantity<>(unit.fromBase(result), unit);
    }

    public Quantity<U> subtract(Quantity<U> other) {
        unit.validateOperationSupport("SUBTRACT");
        double result = this.toBase() - other.toBase();
        return new Quantity<>(unit.fromBase(result), unit);
    }

    public double divide(Quantity<U> other) {
        if (other.toBase() == 0) {
            throw new RuntimeException("Cannot divide by zero");
        }
        unit.validateOperationSupport("DIVIDE");
        return this.toBase() / other.toBase();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Quantity<?> other)) return false;

        if (!unit.getMeasurementType().equals(other.unit.getMeasurementType())) {
            return false;
        }

        double base1 = this.toBase();
        double base2 = other.unit.toBase(other.value);

        return Math.abs(base1 - base2) < 0.0001;
    }

    public Quantity<U> convertTo(U target) {
        double base = this.toBase();
        double converted = target.fromBase(base);
        return new Quantity<>(converted, target);
    }
}
