package com.apps.quantitymeasurement.uc8;

public class QuantityMeasurementApp {
    public static boolean demonstrateLengthEqually(Length length1, Length length2){
        if(length1==null || length2==null) throw new IllegalArgumentException("Length cannot be null");
        return length1.equals(length2);
    }
    public static boolean demonstrateLengthComparison(double value1, LengthUnit unit1, double value2, LengthUnit unit2){
        Length l1=new Length(value1,unit1);
        Length l2=new Length(value2,unit2);
        return l1.equals(l2);
    }
    public static Length demonstrateLengthConversion(double value,LengthUnit fromUnit,LengthUnit toUnit){
        Length length=new Length(value,fromUnit);
        return length.convertTo(toUnit);
    }
    public static Length demonstrateLengthConversion(Length length,LengthUnit toUnit){
        if(length==null || toUnit==null) throw new IllegalArgumentException("Invalid Input");
        return length.convertTo(toUnit);
    }
    public static Length demonstrateLengthAddition(Length length1,Length length2){
        if(length1==null || length2==null) throw new IllegalArgumentException("Length cannot be null");
        return length1.add(length2);
    }
    public static Length demonstrateLengthAddition(Length length1,Length length2,LengthUnit targetUnit){
        if(length1==null || length2==null || targetUnit==null) throw new IllegalArgumentException("Invalid Input");
        return length1.add(length2,targetUnit);
    }
    public static void main(String[] args) {
        Length l1=new Length(1.0,LengthUnit.FEET);
        Length l2=new Length(12.0,LengthUnit.INCHES);
        System.out.println("Equality: "+demonstrateLengthEqually(l1,l2));
        System.out.println("Comparison: "+demonstrateLengthComparison(1.0,LengthUnit.FEET,12.0,LengthUnit.INCHES));
        System.out.println("Convert 1 ft to inches: "+demonstrateLengthConversion(1.0,LengthUnit.FEET,LengthUnit.INCHES));
        System.out.println("Addition (default unit): "+demonstrateLengthAddition(l1,l2));
        System.out.println("Addition (in inches): "+demonstrateLengthAddition(l1,l2,LengthUnit.INCHES));
    }
}
