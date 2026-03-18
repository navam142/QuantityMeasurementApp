package com.apps.quantitymeasurement.uc5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class QuantityLengthTest {
    private static final double EPSILON=1e-6;
    @Test
    void testFeetToInches(){
        assertEquals(12.0,QuantityLength.convert(1.0,LengthUnit.FEET,LengthUnit.INCHES),EPSILON);
    }

    @Test
    void testYardsToFeet() {
        assertEquals(9.0,
                QuantityLength.convert(3.0, LengthUnit.YARDS, LengthUnit.FEET),
                EPSILON);
    }
    @Test
    void testCmToInches(){
        assertEquals(1.0,QuantityLength.convert(2.54,LengthUnit.CENTIMETERS,LengthUnit.INCHES),EPSILON);
    }
    @Test
    void testSameUnit(){
        assertEquals(5.0,QuantityLength.convert(5.0,LengthUnit.FEET,LengthUnit.FEET),EPSILON);
    }
    @Test
    void testNegativeValue(){
        assertEquals(-12.0,QuantityLength.convert(-1.0,LengthUnit.FEET,LengthUnit.INCHES),EPSILON);
    }
    @Test
    void testInvalidUnit(){
        assertThrows(IllegalArgumentException.class,()->QuantityLength.convert(1.0,null,LengthUnit.FEET));
    }
    @Test
    void testNaNValue(){
        assertThrows(IllegalArgumentException.class,()->QuantityLength.convert(Double.NaN, LengthUnit.FEET,LengthUnit.INCHES));
    }
}