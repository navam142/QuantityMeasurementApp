package com.apps.quantitymeasurement.uc5;

public class QuantityLength{
    private final double value;
    private final LengthUnit unit;
    private static final double EPSILON=1e-6;
    public QuantityLength(double value,LengthUnit unit){
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        if(!Double.isFinite(value)){
            throw new IllegalArgumentException("Invalid numeric value");
        }
        this.value=value;
        this.unit=unit;
    }
    public double toInches(){
        return unit.toInches(value);
    }
    public static double convert(double value,LengthUnit source,LengthUnit target){
        if(source==null || target==null){
            throw new IllegalArgumentException("Units cannot be null");
        }
        if(!Double.isFinite(value)){
            throw new IllegalArgumentException("Invalid numeric value");
        }
        double inches = source.toInches(value);
        return target.fromInches(inches);
    }
    public QuantityLength convertTo(LengthUnit target){
        double convertedValue=convert(this.value,this.unit,target);
        return new QuantityLength(convertedValue,target);
    }
    @Override
    public boolean equals(Object obj){
        if(this==obj) return true;
        if(!(obj instanceof QuantityLength)) return false;
        QuantityLength other=(QuantityLength)obj;
        return Math.abs(this.toInches()-other.toInches())<EPSILON;
    }
    @Override
    public int hashCode(){
        return Double.hashCode(toInches());
    }
    @Override
    public String toString(){
        return value+" "+unit;
    }
}
