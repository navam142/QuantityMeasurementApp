package com.apps.quantitymeasurement.uc6;

public class Length{
    private double value;
    private LengthUnit unit;
    public Length(double value,LengthUnit unit){
        this.value=value;
        this.unit=unit;
    }
    public double getValue(){
        return value;
    }
    public LengthUnit getUnit(){
        return unit;
    }
    private double convertToBaseUnit(){
        return this.value*this.unit.getConversionFactor();
    }
    private boolean compare(Length thatLength){
        if(thatLength==null) return false;
        return Math.abs(this.convertToBaseUnit()-thatLength.convertToBaseUnit())<0.01;
    }
    @Override
    public boolean equals(Object obj){
        if(this==obj) return true;
        if(obj==null) return false;
        if(obj.getClass()!=this.getClass()) return false;
        Length other=(Length)obj;
        return this.compare(other);
    }
    @Override
    public int hashCode(){
        return Double.hashCode(convertToBaseUnit());
    }
    public Length convertTo(LengthUnit targetUnit){
        return new Length(this.convertToBaseUnit()/targetUnit.getConversionFactor(),targetUnit);
    }
    public Length add(Length thatLength){
        if(thatLength==null) throw new IllegalArgumentException("Object cannot be null");
        return new Length((this.convertToBaseUnit()+thatLength.convertToBaseUnit())/this.unit.getConversionFactor(),this.unit);
    }
    private double convertFromBaseToTargetUnit(double lengthInInches,LengthUnit targetUnit){
        return lengthInInches/targetUnit.getConversionFactor();
    }
    @Override
    public String toString(){
        return value+" "+unit;
    }
}
