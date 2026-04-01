package com.apps.quantitymeasurement.uc15.service;

import com.apps.quantitymeasurement.uc15.dto.QuantityDTO;

public interface IQuantityMeasurementService {
    QuantityDTO convert(QuantityDTO input, String targetUnit);

    boolean compare(QuantityDTO q1, QuantityDTO q2);

    QuantityDTO add(QuantityDTO q1, QuantityDTO q2);

    QuantityDTO subtract(QuantityDTO q1, QuantityDTO q2);

    double divide(QuantityDTO q1, QuantityDTO q2);
}
