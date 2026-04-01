package com.apps.quantitymeasurement.uc15.controller;

import com.apps.quantitymeasurement.uc15.dto.QuantityDTO;
import com.apps.quantitymeasurement.uc15.service.IQuantityMeasurementService;

public class QuantityMeasurementController {
    private final IQuantityMeasurementService service;

    public QuantityMeasurementController(IQuantityMeasurementService service) {
        this.service = service;
    }

    // ✅ RETURN VALUES (NOT VOID)

    public QuantityDTO convert(QuantityDTO input, String targetUnit) {
        return service.convert(input, targetUnit);
    }

    public boolean compare(QuantityDTO q1, QuantityDTO q2) {
        return service.compare(q1, q2);
    }

    public QuantityDTO add(QuantityDTO q1, QuantityDTO q2) {
        return service.add(q1, q2);
    }

    public QuantityDTO subtract(QuantityDTO q1, QuantityDTO q2) {
        return service.subtract(q1, q2);
    }

    public double divide(QuantityDTO q1, QuantityDTO q2) {
        return service.divide(q1, q2);
    }
}
