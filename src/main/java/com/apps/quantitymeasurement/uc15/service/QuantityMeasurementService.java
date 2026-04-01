package com.apps.quantitymeasurement.uc15.service;

import com.apps.quantitymeasurement.uc15.dto.QuantityDTO;
import com.apps.quantitymeasurement.uc15.unit.*;

public class QuantityMeasurementService implements IQuantityMeasurementService{
    private IMeasurable resolve(String type, String unit) {
        return switch (type.toLowerCase()) {
            case "length" -> LengthUnit.valueOf(unit);
            case "temperature" -> TemperatureUnit.valueOf(unit);
            case "volume" -> VolumeUnit.valueOf(unit);
            default -> throw new RuntimeException("Invalid type");
        };
    }

    @Override
    public boolean compare(QuantityDTO q1, QuantityDTO q2) {
        try {
            var u1 = resolve(q1.getMeasurementType(), q1.getUnit());
            var u2 = resolve(q2.getMeasurementType(), q2.getUnit());

            var a = new Quantity<>(q1.getValue(), u1);
            var b = new Quantity<>(q2.getValue(), u2);

            return a.equals(b);
        } catch (RuntimeException e) {
            // If types are not compatible, return false
            return false;
        }
    }

    @Override
    public QuantityDTO convert(QuantityDTO input, String targetUnit) {

        var u1 = resolve(input.getMeasurementType(), input.getUnit());
        var target = resolve(input.getMeasurementType(), targetUnit);

        var result = new Quantity<>(input.getValue(), u1).convertTo(target);

        return new QuantityDTO(result.getValue(), targetUnit, input.getMeasurementType());
    }

    @Override
    public QuantityDTO add(QuantityDTO q1, QuantityDTO q2) {

        var u1 = resolve(q1.getMeasurementType(), q1.getUnit());
        var u2 = resolve(q2.getMeasurementType(), q2.getUnit());

        var result = new Quantity<>(q1.getValue(), u1)
                .add(new Quantity<>(q2.getValue(), u2));

        return new QuantityDTO(result.getValue(), q1.getUnit(), q1.getMeasurementType());
    }

    @Override
    public QuantityDTO subtract(QuantityDTO q1, QuantityDTO q2) {

        var u1 = resolve(q1.getMeasurementType(), q1.getUnit());
        var u2 = resolve(q2.getMeasurementType(), q2.getUnit());

        var result = new Quantity<>(q1.getValue(), u1)
                .subtract(new Quantity<>(q2.getValue(), u2));

        return new QuantityDTO(result.getValue(), q1.getUnit(), q1.getMeasurementType());
    }

    @Override
    public double divide(QuantityDTO q1, QuantityDTO q2) {

        var u1 = resolve(q1.getMeasurementType(), q1.getUnit());
        var u2 = resolve(q2.getMeasurementType(), q2.getUnit());

        return new Quantity<>(q1.getValue(), u1)
                .divide(new Quantity<>(q2.getValue(), u2));
    }
}
