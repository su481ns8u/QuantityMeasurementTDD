package com.quantityMeasurement.Utilities;

public interface IUnitsCreatorFactory {
    public double getValue();

    public Units getUnit();

    public void convert(Units unit);
}
