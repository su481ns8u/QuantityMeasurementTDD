package com.quantityMeasurement.Utilities;

import com.quantityMeasurement.Exceptions.QuantityMeasurementException;

public interface IUnitsCreatorFactory {
    public double getValue();

    public void convert(Units unit) throws QuantityMeasurementException;
}
