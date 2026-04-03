package com.apps.quantitymeasurement.uc16.controller;

import com.apps.quantitymeasurement.uc16.entity.QuantityDTO;
import com.apps.quantitymeasurement.uc16.service.IQuantityMeasurementService;

import java.util.logging.Logger;

public class QuantityMeasurementController {

    private static final Logger logger = Logger.getLogger(QuantityMeasurementController.class.getName());
    private IQuantityMeasurementService quantityMeasurementService;

    public QuantityMeasurementController(IQuantityMeasurementService quantityMeasurementService) {
        this.quantityMeasurementService = quantityMeasurementService;
        logger.info("QuantityMeasurementController initialized with service: " + quantityMeasurementService);
    }

    public boolean performComparison(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO) {
        return quantityMeasurementService.compare(thisQuantityDTO, thatQuantityDTO);
    }

    public QuantityDTO performConversion(QuantityDTO thisQuantityDTO, QuantityDTO targetUnitDTO) {
        return quantityMeasurementService.convert(thisQuantityDTO, targetUnitDTO);
    }

    public QuantityDTO performAddition(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO) {
        return quantityMeasurementService.add(thisQuantityDTO, thatQuantityDTO);
    }

    public QuantityDTO performAddition(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO, QuantityDTO targetUnitDTO) {
        return quantityMeasurementService.add(thisQuantityDTO, thatQuantityDTO, targetUnitDTO);
    }

    public QuantityDTO performSubtraction(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO) {
        return quantityMeasurementService.subtract(thisQuantityDTO, thatQuantityDTO);
    }

    public QuantityDTO performSubtraction(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO, QuantityDTO targetUnitDTO) {
        return quantityMeasurementService.subtract(thisQuantityDTO, thatQuantityDTO, targetUnitDTO);
    }

    public double performDivision(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO) {
        return quantityMeasurementService.divide(thisQuantityDTO, thatQuantityDTO);
    }
}
