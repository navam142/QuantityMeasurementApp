package com.apps.quantitymeasurement.uc8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {
    private static final double EPSILON=0.0001;
    @Test
    public void testInchesInequality(){
        Length l1=new Length(10.0,LengthUnit.INCHES);
        Length l2=new Length(12.0,LengthUnit.INCHES);
        assertFalse(l1.equals(l2));
    }
    @Test
    public void testCrossUnitInequality(){
        Length l1=new Length(1.0,LengthUnit.FEET);
        Length l2=new Length(10.0,LengthUnit.INCHES);
        assertFalse(l1.equals(l2));
    }
    @Test
    public void testMultipleFeetComparison(){
        Length l1=new Length(3.0,LengthUnit.FEET);
        Length l2=new Length(1.0,LengthUnit.YARDS);
        assertTrue(l1.equals(l2));
    }
    @Test
    public void yardEquals36Inches(){
        Length yard=new Length(1.0,LengthUnit.YARDS);
        Length inches=new Length(36.0,LengthUnit.INCHES);
        assertTrue(yard.equals(inches));
    }
    @Test
    public void centimeterEquals39Point3701Inches(){
        Length cm=new Length(100.0,LengthUnit.CENTIMETERS);
        Length inches=new Length(39.3701,LengthUnit.INCHES);
        assertTrue(cm.equals(inches));
    }
    @Test
    public void threeFeetEqualsOneYard(){
        Length feet=new Length(3.0,LengthUnit.FEET);
        Length yard=new Length(1.0,LengthUnit.YARDS);
        assertTrue(feet.equals(yard));
    }
    @Test
    public void thirtyPoint48CmEqualsOneFoot(){
        Length cm=new Length(30.48,LengthUnit.CENTIMETERS);
        Length foot=new Length(1.0,LengthUnit.FEET);
        assertTrue(cm.equals(foot));
    }
    @Test
    public void yardNotEqualToInches(){
        Length yard=new Length(1.0,LengthUnit.YARDS);
        Length inches=new Length(35.0,LengthUnit.INCHES);
        assertFalse(yard.equals(inches));
    }
    @Test
    public void referenceEqualitySameObject(){
        Length l=new Length(1.0,LengthUnit.FEET);
        assertTrue(l.equals(l));
    }
    @Test
    public void equalsReturnsFalseForNull(){
        Length l=new Length(1.0,LengthUnit.FEET);
        assertFalse(l.equals(null));
    }
    @Test
    public void reflexiveSymmetricAndTransitiveProperty(){
        Length a=new Length(1.0,LengthUnit.YARDS);
        Length b=new Length(3.0,LengthUnit.FEET);
        Length c=new Length(36.0,LengthUnit.INCHES);
        assertTrue(a.equals(a));
        assertTrue(a.equals(b));
        assertTrue(b.equals(a));
        assertTrue(a.equals(b));
        assertTrue(b.equals(c));
        assertTrue(a.equals(c));
    }
    @Test
    public void differentValuesSameUnitNotEqual(){
        Length l1=new Length(5.0,LengthUnit.FEET);
        Length l2=new Length(6.0,LengthUnit.FEET);
        assertFalse(l1.equals(l2));
    }
    @Test
    public void crossUnitEqualityDemonstrateMethod() {
        boolean result=QuantityMeasurementApp.demonstrateLengthComparison(1.0,LengthUnit.FEET,12.0,LengthUnit.INCHES);
        assertTrue(result);
    }
    @Test
    public void convertFeetToInches(){
        Length result=QuantityMeasurementApp.demonstrateLengthConversion(1.0,LengthUnit.FEET,LengthUnit.INCHES);
        assertEquals(12.0,result.getValue(),EPSILON);
    }
    @Test
    public void convertYardsToInchesUsingOverloadedMethod(){
        Length yard=new Length(1.0,LengthUnit.YARDS);
        Length result=QuantityMeasurementApp.demonstrateLengthConversion(yard,LengthUnit.INCHES);
        assertEquals(36.0,result.getValue(),EPSILON);
    }
    @Test
    public void addFeetAndInches(){
        Length l1=new Length(1.0,LengthUnit.FEET);
        Length l2=new Length(12.0,LengthUnit.INCHES);
        Length result=QuantityMeasurementApp.demonstrateLengthAddition(l1,l2);
        assertEquals(2.0,result.getValue(),EPSILON);
        assertEquals(LengthUnit.FEET,result.getUnit());
    }
    @Test
    public void addFeetAndInchesWithTargetUnitInches(){
        Length l1=new Length(1.0,LengthUnit.FEET);
        Length l2=new Length(12.0,LengthUnit.INCHES);
        Length result=QuantityMeasurementApp.demonstrateLengthAddition(l1,l2,LengthUnit.INCHES);
        assertEquals(24.0,result.getValue(),EPSILON);
        assertEquals(LengthUnit.INCHES,result.getUnit());
    }
}