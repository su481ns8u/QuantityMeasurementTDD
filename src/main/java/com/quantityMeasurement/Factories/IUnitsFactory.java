package com.quantityMeasurement.Factories;

import com.quantityMeasurement.Exceptions.QuantityMeasurementException;
import com.quantityMeasurement.Utilities.Units;

public interface IUnitsFactory {
    public Units getUnit();

    public double getValue();

    public void convertToBase() throws QuantityMeasurementException;
}
