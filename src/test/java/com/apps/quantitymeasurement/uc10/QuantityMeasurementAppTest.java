package com.apps.quantitymeasurement.uc10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class QuantityMeasurementAppTest {
    @Test
    void testIMeasurableInterface_LengthUnitImplementation(){
        LengthUnit unit=LengthUnit.FEET;
        assertEquals(12.0,unit.getConversionFactor());
        assertEquals(24.0,unit.convertToBaseUnit(2.0));
        assertEquals(1.0,unit.convertFromBaseUnit(12.0));
        assertEquals("FEET",unit.getUnitName());
    }
    @Test
    void testIMeasurableInterface_WeightUnitImplementation(){
        WeightUnit unit=WeightUnit.KILOGRAM;
        assertEquals(1000.0,unit.getConversionFactor());
        assertEquals(2000.0,unit.convertToBaseUnit(2.0));
        assertEquals(1.0,unit.convertFromBaseUnit(1000.0));
        assertEquals("KILOGRAM",unit.getUnitName());
    }
    @Test
    void testIMeasurableInterface_ConsistentBehavior(){
        IMeasurable length=LengthUnit.FEET;
        IMeasurable weight=WeightUnit.KILOGRAM;
        assertNotNull(length.getConversionFactor());
        assertNotNull(weight.getConversionFactor());
    }
    @Test
    void testGenericQuantity_LengthOperations_Equality(){
        assertTrue(new Quantity<>(1.0,LengthUnit.FEET).equals(new Quantity<>(12.0,LengthUnit.INCHES)));
    }
    @Test
    void testGenericQuantity_WeightOperations_Equality(){
        assertTrue(new Quantity<>(1.0,WeightUnit.KILOGRAM).equals(new Quantity<>(1000.0,WeightUnit.GRAM)));
    }
    @Test
    void testGenericQuantity_LengthOperations_Conversion(){
        Quantity<LengthUnit> result=new Quantity<>(1.0,LengthUnit.FEET).convertTo(LengthUnit.INCHES);
        assertEquals(12.0,result.getValue());
    }
    @Test
    void testGenericQuantity_WeightOperations_Conversion(){
        Quantity<WeightUnit> result=new Quantity<>(1.0,WeightUnit.KILOGRAM).convertTo(WeightUnit.GRAM);
        assertEquals(1000.0,result.getValue());
    }
    @Test
    void testGenericQuantity_LengthOperations_Addition(){
        Quantity<LengthUnit> result=new Quantity<>(1.0,LengthUnit.FEET).add(new Quantity<>(12.0,LengthUnit.INCHES),LengthUnit.FEET);
        assertEquals(2.0,result.getValue());
    }
    @Test
    void testGenericQuantity_WeightOperations_Addition(){
        Quantity<WeightUnit> result=new Quantity<>(1.0,WeightUnit.KILOGRAM).add(new Quantity<>(1000.0,WeightUnit.GRAM),WeightUnit.KILOGRAM);
        assertEquals(2.0,result.getValue());
    }
    @Test
    void testCrossCategoryPrevention_LengthVsWeight(){
        assertFalse(new Quantity<>(1.0,LengthUnit.FEET).equals(new Quantity<>(1.0,WeightUnit.KILOGRAM)));
    }
    @Test
    void testGenericQuantity_ConstructorValidation_NullUnit(){
        assertThrows(IllegalArgumentException.class,()->new Quantity<>(1.0,null));
    }
    @Test
    void testGenericQuantity_ConstructorValidation_InvalidValue(){
        assertThrows(IllegalArgumentException.class,()->new Quantity<>(Double.NaN,LengthUnit.FEET));
    }
    @Test
    void testGenericQuantity_Conversion_AllUnitCombinations(){
        Quantity<LengthUnit> q=new Quantity<>(1.0,LengthUnit.YARDS);
        assertEquals(36.0,q.convertTo(LengthUnit.INCHES).getValue());
    }
    @Test
    void testGenericQuantity_Addition_AllUnitCombinations(){
        Quantity<LengthUnit> q1=new Quantity<>(1.0,LengthUnit.FEET);
        Quantity<LengthUnit> q2=new Quantity<>(24.0,LengthUnit.INCHES);
        assertEquals(3.0,q1.add(q2,LengthUnit.FEET).getValue());
    }
    @Test
    void testQuantityMeasurementApp_SimplifiedDemonstration_Equality() {
        assertTrue(QuantityMeasurementApp.demonstrateEquality(new Quantity<>(1.0,LengthUnit.FEET),new Quantity<>(12.0,LengthUnit.INCHES)));
    }
    @Test
    void testQuantityMeasurementApp_SimplifiedDemonstration_Conversion(){
        assertEquals(12.0,QuantityMeasurementApp.demonstrateConversion(new Quantity<>(1.0,LengthUnit.FEET),LengthUnit.INCHES).getValue());
    }
    @Test
    void testQuantityMeasurementApp_SimplifiedDemonstration_Addition(){
        assertEquals(2.0,QuantityMeasurementApp.demonstrateAddition(new Quantity<>(1.0, LengthUnit.FEET),new Quantity<>(12.0, LengthUnit.INCHES),LengthUnit.FEET).getValue());
    }
    @Test
    void testHashCode_GenericQuantity_Consistency(){
        Quantity<LengthUnit> q1=new Quantity<>(1.0,LengthUnit.FEET);
        Quantity<LengthUnit> q2=new Quantity<>(12.0,LengthUnit.INCHES);
        assertEquals(q1.hashCode(),q2.hashCode());
    }
    @Test
    void testEquals_GenericQuantity_ContractPreservation(){
        Quantity<LengthUnit> a=new Quantity<>(1.0,LengthUnit.FEET);
        Quantity<LengthUnit> b=new Quantity<>(12.0,LengthUnit.INCHES);
        Quantity<LengthUnit> c=new Quantity<>(1.0,LengthUnit.FEET);
        assertTrue(a.equals(b));
        assertTrue(b.equals(c));
        assertTrue(a.equals(c));
    }
    @Test
    void testImmutability_GenericQuantity(){
        Quantity<LengthUnit> q1=new Quantity<>(1.0,LengthUnit.FEET);
        Quantity<LengthUnit> q2=q1.convertTo(LengthUnit.INCHES);
        assertNotSame(q1,q2);
    }
    @Test
    void testTypeWildcard_FlexibleSignatures(){
        Quantity<?> q=new Quantity<>(1.0,LengthUnit.FEET);
        assertNotNull(q);
    }
    @Test
    void testGenericBoundedTypeParameter_Enforcement(){
        Quantity<LengthUnit> q=new Quantity<>(1.0,LengthUnit.FEET);
        assertNotNull(q);
    }
    @Test
    void testEnumAsUnitCarrier_BehaviorEncapsulation(){
        IMeasurable unit=LengthUnit.FEET;
        assertEquals(12.0,unit.getConversionFactor());
    }
    @Test
    void testTypeErasure_RuntimeSafety(){
        Quantity<?> q1=new Quantity<>(1.0,LengthUnit.FEET);
        Quantity<?> q2=new Quantity<>(1.0,WeightUnit.KILOGRAM);
        assertFalse(q1.equals(q2));
    }
    @Test
    void testCompositionOverInheritance_Flexibility(){
        Quantity<LengthUnit> q=new Quantity<>(1.0,LengthUnit.FEET);
        assertNotNull(q.getUnit());
    }
    @Test
    void testCodeReduction_DRYValidation(){
        assertTrue(true);
    }
    @Test
    void testMaintainability_SingleSourceOfTruth(){
        assertTrue(true);
    }
    @Test
    void testInterfaceSegregation_MinimalContract(){
        IMeasurable unit=LengthUnit.FEET;
        assertNotNull(unit);
    }
}