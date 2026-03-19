package com.apps.quantitymeasurement.uc8;

public class Length {
    private double value;
    private LengthUnit unit;
    public Length(double value,LengthUnit unit){
        if(unit==null) throw new IllegalArgumentException("Unit cannot be null");
        this.value=value;
        this.unit=unit;
    }
    public double getValue(){
        return value;
    }
    public LengthUnit getUnit(){
        return unit;
    }
    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(!(o instanceof Length other)) return false;
        return compare((Length) o);
    }
    public Length convertTo(LengthUnit targetUnit){
        double base=unit.convertToBaseUnit(value);
        double converted=targetUnit.convertFromBaseUnit(base);
        return new Length(converted,targetUnit);
    }
    public Length add(Length thatLength){
        return add(thatLength,this.unit);
    }
    public Length add(Length length,LengthUnit targetUnit){
        double base1=this.unit.convertToBaseUnit(this.value);
        double base2=length.unit.convertToBaseUnit(length.value);
        double sum=base1+base2;
        double result=targetUnit.convertFromBaseUnit(sum);
        return new Length(result,targetUnit);
    }
    private boolean compare(Length thatLength){
        if(thatLength==null) return false;
        double base1=this.unit.convertToBaseUnit(this.value);
        double base2=thatLength.unit.convertToBaseUnit(thatLength.value);
        return Math.abs(base1-base2)<0.0001;
    }
    private Length addAndConvert(Length length,LengthUnit targetUnit){
        double base1=this.unit.convertToBaseUnit(this.value);
        double base2=length.unit.convertToBaseUnit(length.value);
        double sum=base1+base2;
        double result=targetUnit.convertFromBaseUnit(sum);
        return new Length(result,targetUnit);
    }
    private double convertToBaseUnit(){
        return this.unit.convertToBaseUnit(value);
    }
    private double convertFromBaseToTargetUnit(double lengthInInches,LengthUnit targetUnit){
        return targetUnit.convertFromBaseUnit(lengthInInches);
    }
    @Override
    public String toString(){
        return value+" "+unit;
    }
}
