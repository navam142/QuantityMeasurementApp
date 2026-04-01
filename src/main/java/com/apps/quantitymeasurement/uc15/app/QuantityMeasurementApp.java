package com.apps.quantitymeasurement.uc15.app;

import com.apps.quantitymeasurement.uc15.controller.QuantityMeasurementController;
import com.apps.quantitymeasurement.uc15.dto.QuantityDTO;
import com.apps.quantitymeasurement.uc15.service.QuantityMeasurementService;

public class QuantityMeasurementApp {
    public static void main(String[] args) {

        var service = new QuantityMeasurementService();
        var controller = new QuantityMeasurementController(service);

        // Test 1: Compare same temperature in different units
        QuantityDTO t1 = new QuantityDTO(0, "CELSIUS", "temperature");
        QuantityDTO t2 = new QuantityDTO(32, "FAHRENHEIT", "temperature");
        boolean isEqual = controller.compare(t1, t2);
        System.out.println("Test 1 - Compare 0°C with 32°F: " + isEqual);

        // Test 2: Convert Celsius to Fahrenheit
        QuantityDTO convertResult = controller.convert(t1, "FAHRENHEIT");
        System.out.println("Test 2 - Convert 0°C to Fahrenheit: " + convertResult.getValue() + "°F");

        // Test 3: Add length measurements
        QuantityDTO l1 = new QuantityDTO(10, "FEET", "length");
        QuantityDTO l2 = new QuantityDTO(12, "INCHES", "length");
        QuantityDTO addResult = controller.add(l1, l2);
        System.out.println("Test 3 - Add 10 FEET + 12 INCHES: " + addResult.getValue() + " " + addResult.getUnit());

        // Test 4: Subtract volume measurements
        QuantityDTO v1 = new QuantityDTO(5, "LITRE", "volume");
        QuantityDTO v2 = new QuantityDTO(2, "LITRE", "volume");
        QuantityDTO subtractResult = controller.subtract(v1, v2);
        System.out.println("Test 4 - Subtract 5 LITRE - 2 LITRE: " + subtractResult.getValue() + " " + subtractResult.getUnit());

        // Test 5: Divide length measurements
        QuantityDTO d1 = new QuantityDTO(20, "FEET", "length");
        QuantityDTO d2 = new QuantityDTO(2, "FEET", "length");
        double divideResult = controller.divide(d1, d2);
        System.out.println("Test 5 - Divide 20 FEET by 2 FEET: " + divideResult);
    }
}
