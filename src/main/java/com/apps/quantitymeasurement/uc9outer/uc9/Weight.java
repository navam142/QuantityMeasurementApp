package com.apps.quantitymeasurement.uc9outer.uc9;

public class Weight {
    private final double value;
    private final WeightUnit unit;
    private static final double EPSILON=0.0001;
    public Weight(double value, WeightUnit unit) {
        if(unit==null) throw new IllegalArgumentException("Unit cannot be null");
        this.value=value;
        this.unit=unit;
    }
    public double getValue(){
        return value;
    }
    public WeightUnit getUnit(){
        return unit;
    }
    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(!(o instanceof Weight other)) return false;
        double base1=this.unit.convertToBaseUnit(this.value);
        double base2=other.unit.convertToBaseUnit(other.value);
        return Math.abs(base1-base2)<EPSILON;
    }
    public Weight convertTo(WeightUnit targetUnit){
        if(targetUnit==null) throw new IllegalArgumentException("Target unit cannot be null");
        double base=unit.convertToBaseUnit(value);
        double converted=targetUnit.convertFromBaseUnit(base);
        return new Weight(converted,targetUnit);
    }
    public Weight add(Weight other){
        return add(other,this.unit);
    }
    public Weight add(Weight other,WeightUnit targetUnit){
        if(other==null || targetUnit==null) throw new IllegalArgumentException("Invalid input");
        double base1=this.unit.convertToBaseUnit(this.value);
        double base2=other.unit.convertToBaseUnit(other.value);
        double sum=base1+base2;
        double result=targetUnit.convertFromBaseUnit(sum);
        return new Weight(result,targetUnit);
    }
    private double convertToBaseUnit(){
        return this.unit.convertToBaseUnit(this.value);
    }
    private double convertFromBaseToTargetUnit(double baseValue,WeightUnit targetUnit){
        return targetUnit.convertFromBaseUnit(baseValue);
    }
    private boolean compare(Weight other){
        if(other==null) return false;
        double base1=this.convertToBaseUnit();
        double base2=other.convertToBaseUnit();
        return Math.abs(base1-base2)<0.0001;
    }
    private Weight addAndConvert(Weight other,WeightUnit targetUnit){
        if(other==null || targetUnit==null) throw new IllegalArgumentException("Invalid input");
        double base1=this.convertToBaseUnit();
        double base2=other.convertToBaseUnit();
        double sum=base1+base2;
        double result=convertFromBaseToTargetUnit(sum,targetUnit);
        return new Weight(result,targetUnit);
    }
    @Override
    public String toString(){
        return value+" "+unit;
    }
}
