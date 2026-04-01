package com.apps.quantitymeasurement.uc15.repository;

import com.apps.quantitymeasurement.uc15.entity.QuantityMeasurementEntity;

import java.util.List;

public interface IQuantityMeasurementRepository {
    void save(QuantityMeasurementEntity entity);

    List<QuantityMeasurementEntity> findAll();
}
