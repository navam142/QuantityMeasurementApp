package com.apps.quantitymeasurement.uc16;

import com.apps.quantitymeasurement.uc16.controller.QuantityMeasurementController;
import com.apps.quantitymeasurement.uc16.entity.QuantityDTO;
import com.apps.quantitymeasurement.uc16.entity.QuantityMeasurementEntity;
import com.apps.quantitymeasurement.uc16.repository.IQuantityMeasurementRepository;
import com.apps.quantitymeasurement.uc16.repository.QuantityMeasurementCacheRepository;
import com.apps.quantitymeasurement.uc16.repository.QuantityMeasurementDatabaseRepository;
import com.apps.quantitymeasurement.uc16.service.IQuantityMeasurementService;
import com.apps.quantitymeasurement.uc16.service.QuantityMeasurementServiceImpl;
import com.apps.quantitymeasurement.uc16.util.ApplicationConfig;
import com.apps.quantitymeasurement.uc16.exception.*;

import java.util.List;
import java.util.logging.Logger;

public class QuantityMeasurementApp {

    private static final Logger logger = Logger.getLogger(QuantityMeasurementApp.class.getName());
    private static QuantityMeasurementApp instance;
    private QuantityMeasurementController controller;
    private IQuantityMeasurementRepository repository;

    private QuantityMeasurementApp() {
        ApplicationConfig config = ApplicationConfig.getInstance();
        String repoType = config.getProperty("repository.type", "database");

        if ("cache".equalsIgnoreCase(repoType)) {
            this.repository = QuantityMeasurementCacheRepository.getInstance();
            logger.info("Quantity Measurement Application initialized with Cache Repository");
        } else {
            this.repository = QuantityMeasurementDatabaseRepository.getInstance();
            logger.info("Quantity Measurement Application initialized with Database Repository");
        }

        IQuantityMeasurementService service = new QuantityMeasurementServiceImpl(this.repository);
        this.controller = new QuantityMeasurementController(service);
    }

    public static synchronized QuantityMeasurementApp getInstance() {
        if (instance == null) {
            instance = new QuantityMeasurementApp();
        }
        return instance;
    }

    public QuantityMeasurementController getController() {
        return controller;
    }

    public IQuantityMeasurementRepository getRepository() {
        return repository;
    }

    public void closeResources() {
        if (repository != null) {
            repository.releaseResources();
        }
    }

    public void deleteAllMeasurements() {
        if (repository != null) {
            repository.deleteAll();
        }
    }

    public static void main(String[] args) {
        QuantityMeasurementApp app = getInstance();
        QuantityMeasurementController controller = app.getController();

        try {
            // Testing comparison of two quantities
            QuantityDTO quantity1 = new QuantityDTO(2, QuantityDTO.LengthUnit.FEET.getUnitName(), QuantityDTO.LengthUnit.FEET.getMeasurementType());
            QuantityDTO quantity2 = new QuantityDTO(24, QuantityDTO.LengthUnit.INCHES.getUnitName(), QuantityDTO.LengthUnit.INCHES.getMeasurementType());

            boolean comparisonResult = controller.performComparison(quantity1, quantity2);
            logger.info("Comparison result (2 FEET == 24 INCHES): " + comparisonResult);

            // 2. Temperature Addition Attempt
            QuantityDTO t1 = new QuantityDTO(0.0, QuantityDTO.TemperatureUnit.CELSIUS.getUnitName(), QuantityDTO.TemperatureUnit.CELSIUS.getMeasurementType());
            QuantityDTO t2 = new QuantityDTO(32.0, QuantityDTO.TemperatureUnit.FAHRENHEIT.getUnitName(), QuantityDTO.TemperatureUnit.FAHRENHEIT.getMeasurementType());
            try {
                controller.performAddition(t1, t2);
            } catch (QuantityMeasurementException e) {
                logger.warning("Expected Error: " + e.getMessage());
            }

            // 3. Cross-Category Operation Prevention
            QuantityDTO length = new QuantityDTO(1.0, QuantityDTO.LengthUnit.FEET.getUnitName(), QuantityDTO.LengthUnit.FEET.getMeasurementType());
            QuantityDTO weight = new QuantityDTO(1.0, QuantityDTO.WeightUnit.KILOGRAM.getUnitName(), QuantityDTO.WeightUnit.KILOGRAM.getMeasurementType());
            try {
                controller.performComparison(length, weight);
            } catch (QuantityMeasurementException e) {
                logger.warning("Expected Error: " + e.getMessage());
            }

            // Report all measurements
            logger.info("--- Operation History from Repository ---");
            List<QuantityMeasurementEntity> history = app.getRepository().getAllMeasurements();
            for (QuantityMeasurementEntity entity : history) {
                logger.info(entity.toString());
            }

            // Cleanup for demonstration
            // app.deleteAllMeasurements();

        } finally {
            app.closeResources();
        }
    }
}