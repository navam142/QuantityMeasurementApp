package com.apps.quantitymeasurement.uc3;

public class QuantityMeasurementApp {
    public static void demonstrateLengthEquality(Length length1, Length length2) {
        if (length1.equals(length2)) {
            System.out.println("Length equal");
        } else {
            System.out.println("Length not equal");
        }
    }

    public static void demonstrateFeetEquality() {
        Length l1 = new Length(1, Length.LengthUnit.FEET);
        Length l2 = new Length(1, Length.LengthUnit.FEET);

        if (l1.equals(l2)) {
            System.out.println("Feet equal");
        }  else {
            System.out.println("Feet not equal");
        }
    }

    public static void demonstrateInchesEquality() {
        Length l1 = new Length(1.0, Length.LengthUnit.INCHES);
        Length l2 = new Length(1.0, Length.LengthUnit.INCHES);
        if (l1.equals(l2)) {
            System.out.println("Inches equal");
        } else {
            System.out.println("Inches not equal");
        }
    }

    public static void demonstrateFeetInchesComparison() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(12.0, Length.LengthUnit.INCHES);
        if (l1.equals(l2)) {
            System.out.println("Values equal");
        } else {
            System.out.println("Values not equal");
        }
    }

    public static void main(String[] args) {
        demonstrateLengthEquality(new Length(1, Length.LengthUnit.FEET), new Length(1, Length.LengthUnit.FEET));
        demonstrateFeetEquality();
        demonstrateInchesEquality();
        demonstrateFeetInchesComparison();
    }
}
