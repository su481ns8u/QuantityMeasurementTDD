package com.quantityMeasurement.Utilities;

import com.quantityMeasurement.Exceptions.QuantityMeasurementException;

public interface IUnitsFactory {
    public double getValue();

    public void convert(Units unit) throws QuantityMeasurementException;

    public void checkUnitAcceptance(Units unit) throws QuantityMeasurementException;
}
