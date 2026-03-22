package com.apps.quantitymeasurement.uc9outer.uc9;

import com.apps.quantitymeasurement.uc9outer.uc8.Length;
import com.apps.quantitymeasurement.uc9outer.uc8.LengthUnit;

public class QuantityMeasurementApp {
    public static boolean demonstrateWeightEquality(Weight w1, Weight w2){
        if(w1==null || w2==null) throw new IllegalArgumentException("Weight cannot be null");
        return w1.equals(w2);
    }
    public static boolean demonstrateWeightComparison(double v1,WeightUnit u1,double v2,WeightUnit u2){
        Weight w1=new Weight(v1,u1);
        Weight w2=new Weight(v2,u2);
        return w1.equals(w2);
    }
    public static Weight demonstrateWeightConversion(double value,WeightUnit from,WeightUnit to){
        Weight weight=new Weight(value,from);
        return weight.convertTo(to);
    }
    public static Weight demonstrateWeightConversion(Weight weight,WeightUnit to){
        if(weight==null || to==null) throw new IllegalArgumentException("Invalid input");
        return weight.convertTo(to);
    }
    public static Weight demonstrateWeightAddition(Weight w1,Weight w2){
        if(w1==null || w2==null) throw new IllegalArgumentException("Weight cannot be null");
        return w1.add(w2);
    }
    public static Weight demonstrateWeightAddition(Weight w1,Weight w2,WeightUnit targetUnit){
        if(w1==null || w2==null || targetUnit==null) throw new IllegalArgumentException("Invalid input");
        return w1.add(w2,targetUnit);
    }
    public static boolean demonstrateLengthEquality(Length l1, Length l2){
        if(l1==null || l2==null) throw new IllegalArgumentException("Length cannot be null");
        return l1.equals(l2);
    }
    public static boolean demonstrateLengthComparison(double v1,LengthUnit u1,double v2,LengthUnit u2){
        Length l1=new Length(v1, u1);
        Length l2=new Length(v2, u2);
        return l1.equals(l2);
    }
    public static Length demonstrateLengthConversion(double value,LengthUnit from,LengthUnit to){
        Length length=new Length(value,from);
        return length.convertTo(to);
    }
    public static Length demonstrateLengthConversion(Length length,LengthUnit to){
        if(length==null || to==null) throw new IllegalArgumentException("Invalid input");
        return length.convertTo(to);
    }
    public static Length demonstrateLengthAddition(Length l1,Length l2){
        if(l1==null || l2==null) throw new IllegalArgumentException("Length cannot be null");
        return l1.add(l2);
    }
    public static Length demonstrateLengthAddition(Length l1,Length l2,LengthUnit targetUnit){
        if(l1==null || l2==null || targetUnit==null) throw new IllegalArgumentException("Invalid input");
        return l1.add(l2,targetUnit);
    }
    public static void main(String[] args) {
        Length l1=new Length(1.0, LengthUnit.FEET);
        Length l2=new Length(12.0,LengthUnit.INCHES);
        System.out.println("Length Equality: "+demonstrateLengthEquality(l1,l2));
        System.out.println("Length Conversion (Feet → Inches): "+demonstrateLengthConversion(1.0,LengthUnit.FEET,LengthUnit.INCHES));
        System.out.println("Length Addition: "+demonstrateLengthAddition(l1,l2));
        Weight w1=new Weight(1.0,WeightUnit.KILOGRAM);
        Weight w2=new Weight(1000.0,WeightUnit.GRAM);
        System.out.println("Weight Equality: "+demonstrateWeightEquality(w1,w2));
        System.out.println("Weight Conversion (Kg → Gram): "+demonstrateWeightConversion(1.0,WeightUnit.KILOGRAM,WeightUnit.GRAM));
        System.out.println("Weight Addition: "+demonstrateWeightAddition(w1,w2));
        System.out.println("Weight Addition (Target = Pound): "+demonstrateWeightAddition(w1,w2,WeightUnit.POUND));
    }
}
