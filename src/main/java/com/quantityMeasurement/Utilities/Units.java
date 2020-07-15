package com.quantityMeasurement.Utilities;

public interface Units {
    public double getValue();
    public Unit getUnit();
    public void convert(Unit unit);
}
