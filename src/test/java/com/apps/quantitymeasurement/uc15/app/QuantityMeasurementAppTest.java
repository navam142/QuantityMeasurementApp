package com.apps.quantitymeasurement.uc15.app;

import com.apps.quantitymeasurement.uc15.controller.QuantityMeasurementController;
import com.apps.quantitymeasurement.uc15.dto.QuantityDTO;
import com.apps.quantitymeasurement.uc15.service.IQuantityMeasurementService;
import com.apps.quantitymeasurement.uc15.service.QuantityMeasurementService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class QuantityMeasurementAppTest {
    private QuantityMeasurementController controller;

    @BeforeEach
    void setup() {
        IQuantityMeasurementService service = new QuantityMeasurementService();

        controller = new QuantityMeasurementController(service);
    }

    @Test
    void testService_CompareEquality_SameUnit_Success() {
        QuantityDTO q1 = new QuantityDTO(10.0, "FEET", "LENGTH");
        QuantityDTO q2 = new QuantityDTO(10.0, "FEET", "LENGTH");

        assertTrue(controller.compare(q1, q2));
    }

    @Test
    void testService_CompareEquality_DifferentUnit_Success() {
        QuantityDTO q1 = new QuantityDTO(0.0, "CELSIUS", "TEMPERATURE");
        QuantityDTO q2 = new QuantityDTO(32.0, "FAHRENHEIT", "TEMPERATURE");

        assertTrue(controller.compare(q1, q2));
    }

    @Test
    void testService_CompareEquality_CrossCategory_Error() {
        QuantityDTO q1 = new QuantityDTO(10.0, "FEET", "LENGTH");
        QuantityDTO q2 = new QuantityDTO(10.0, "KILOGRAM", "WEIGHT");

        assertFalse(controller.compare(q1, q2));
    }

    @Test
    void testService_Convert_Success() {
        QuantityDTO input = new QuantityDTO(0.0, "CELSIUS", "TEMPERATURE");

        QuantityDTO result = controller.convert(input, "FAHRENHEIT");

        assertEquals(32.0, result.getValue(), 0.01);
    }

    @Test
    void testService_Convert_Length() {
        QuantityDTO input = new QuantityDTO(12.0, "INCHES", "LENGTH");

        QuantityDTO result = controller.convert(input, "FEET");

        assertEquals(1.0, result.getValue(), 0.01);
    }

    @Test
    void testService_Add_Success() {
        QuantityDTO q1 = new QuantityDTO(10.0, "FEET", "LENGTH");
        QuantityDTO q2 = new QuantityDTO(12.0, "INCHES", "LENGTH");

        QuantityDTO result = controller.add(q1, q2);

        assertEquals(11.0, result.getValue(), 0.01);
    }

    @Test
    void testService_Add_UnsupportedOperation_Error() {
        QuantityDTO q1 = new QuantityDTO(100.0, "CELSIUS", "TEMPERATURE");
        QuantityDTO q2 = new QuantityDTO(50.0, "CELSIUS", "TEMPERATURE");

        Exception exception = assertThrows(RuntimeException.class, () -> {
            controller.add(q1, q2);
        });

        assertTrue(exception.getMessage().contains("Temperature"));
    }


    @Test
    void testService_Subtract_Success() {
        QuantityDTO q1 = new QuantityDTO(5.0, "LITRE", "VOLUME");
        QuantityDTO q2 = new QuantityDTO(2.0, "LITRE", "VOLUME");

        QuantityDTO result = controller.subtract(q1, q2);

        assertEquals(3.0, result.getValue(), 0.01);
    }


    @Test
    void testService_Divide_Success() {
        QuantityDTO q1 = new QuantityDTO(20.0, "FEET", "LENGTH");
        QuantityDTO q2 = new QuantityDTO(2.0, "FEET", "LENGTH");

        double result = controller.divide(q1, q2);

        assertEquals(10.0, result, 0.01);
    }

    @Test
    void testService_Divide_ByZero_Error() {
        QuantityDTO q1 = new QuantityDTO(20.0, "FEET", "LENGTH");
        QuantityDTO q2 = new QuantityDTO(0.0, "FEET", "LENGTH");

        assertThrows(RuntimeException.class, () -> {
            controller.divide(q1, q2);
        });
    }


    @Test
    void testIntegration_EndToEnd_LengthAddition() {
        QuantityDTO q1 = new QuantityDTO(10.0, "FEET", "LENGTH");
        QuantityDTO q2 = new QuantityDTO(12.0, "INCHES", "LENGTH");

        QuantityDTO result = controller.add(q1, q2);

        assertEquals(11.0, result.getValue(), 0.01);
    }

    @Test
    void testIntegration_EndToEnd_TemperatureUnsupported() {
        QuantityDTO q1 = new QuantityDTO(100.0, "CELSIUS", "TEMPERATURE");
        QuantityDTO q2 = new QuantityDTO(50.0, "CELSIUS", "TEMPERATURE");

        assertThrows(RuntimeException.class, () -> {
            controller.add(q1, q2);
        });
    }
}