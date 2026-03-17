package com.apps.quantitymeasurement.uc2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {
    static QuantityMeasurementApp.Feet f1, f2, f3;
    static QuantityMeasurementApp.Inches i1, i2, i3, i4;

    @BeforeAll
    public static void ff() {
        f1 = new QuantityMeasurementApp.Feet(1.0);
        f2 = new QuantityMeasurementApp.Feet(1.0);
        f3 = new QuantityMeasurementApp.Feet(2.0);
        i1 = new QuantityMeasurementApp.Inches(1.0);
        i2 = new QuantityMeasurementApp.Inches(1.0);
        i3 = new QuantityMeasurementApp.Inches(2.0);
        i4 = i1;
    }

    @Test
    public void testFeetEquality_SameValue() {
        assertEquals(f1, f2);
    }

    @Test
    public void testFeetEquality_DifferentValue() {
        assertNotEquals(f1, f3);
    }

    @Test
    public void testFeetEquality_NullComparison() {
        assertNotEquals(null, f1);
    }

    @Test
    public void testInchesEquality_SameValue() {
        assertEquals(i1, i2);
    }

    @Test
    public void testInchesEquality_DifferentValue() {
        assertNotEquals(i1, i3);
    }

    @Test
    public void testEquality_SameReference() {
        assertEquals(i1, i4);
    }
}