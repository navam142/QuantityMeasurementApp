package com.apps.quantitymeasurement.uc3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    static Length l1, l2, l3, l4, l5, l6, l7;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
         l1 = new Length(1.0, Length.LengthUnit.FEET);
         l2 = new Length(1.0, Length.LengthUnit.FEET);
         l3 = new Length(12.0, Length.LengthUnit.INCHES);
         l4 = new Length(12.0, Length.LengthUnit.INCHES);
         l5 = l4;
         l6 = new Length(2.0, Length.LengthUnit.FEET);
         l7 = new Length(3.0, Length.LengthUnit.INCHES);
    }

    @Test
    public void testFeetEquality() {
        assertEquals(l1, l2);
    }

    @Test
    public void testFeetInequality() {
        assertNotEquals(l1, l6);
    }

    @Test
    public void testInchesEquality() {
        assertEquals(l3, l4);
    }

    @Test
    public void testInchesInequality() {
        assertNotEquals(l3, l7);
    }

    @Test
    public void testFeetInchesEquality() {
        assertEquals(l2, l3);
    }

    @Test
    public void testFeetInchesInequality() {
        assertNotEquals(l2, l7);
    }


}