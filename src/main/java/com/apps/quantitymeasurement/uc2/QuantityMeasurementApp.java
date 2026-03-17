package com.apps.quantitymeasurement.uc2;

public class QuantityMeasurementApp {
    public static class Feet {
        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Feet other = (Feet) obj;
            return Double.compare(this.value, other.value) == 0;
        }
    }

    public static class Inches {
        private final double value;
        public Inches(double value) {
            this.value = value;
        }
        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Inches other = (Inches) obj;
            return Double.compare(this.value, other.value) == 0;
        }
    }

    public static void checkFeetEquality(double v1, double v2) {
        Feet f1 = new Feet(v1);
        Feet f2 = new Feet(v2);
        System.out.println("Input: " + v1 + " ft and " + v2 + " ft");
        System.out.println("Output: Equal (" + f1.equals(f2) + ")");
    }

    public static void checkInchesEquality(double v1, double v2) {

        Inches i1 = new Inches(v1);
        Inches i2 = new Inches(v2);

        System.out.println("Input: " + v1 + " inch and " + v2 + " inch");
        System.out.println("Output: Equal (" + i1.equals(i2) + ")");
    }

    public static void main(String[] args) {
        checkFeetEquality(1.0, 1.0);
        checkInchesEquality(1.0, 1.0);
    }
}
