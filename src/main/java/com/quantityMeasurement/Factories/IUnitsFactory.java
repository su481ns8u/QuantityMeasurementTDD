package com.quantityMeasurement.Factories;

import com.quantityMeasurement.Exceptions.QuantityMeasurementException;

public interface IUnitsFactory {
    public double getValue();

    public void convertToBase() throws QuantityMeasurementException;
}
