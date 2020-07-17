package com.quantityMeasurement.Services;

import com.quantityMeasurement.Exceptions.QuantityMeasurementException;
import com.quantityMeasurement.Factories.IUnitsFactory;

import static com.quantityMeasurement.Exceptions.QuantityMeasurementException.ExceptionType.UNITS_MISMATCH;

public class QuantityOperations {
    public boolean compare(IUnitsFactory unit1, IUnitsFactory unit2) throws QuantityMeasurementException {
        if (unit1 == null || unit2 == null)
            throw new QuantityMeasurementException(QuantityMeasurementException.ExceptionType.INVALID_ARGUMENTS);
        unit1.convertToBase();
        unit2.convertToBase();
        return unit1.equals(unit2);
    }

    public double addUnits(IUnitsFactory unit1, IUnitsFactory unit2) throws QuantityMeasurementException {
        if (unit1.getClass() == unit2.getClass()) {
            unit1.convertToBase();
            unit2.convertToBase();
            return unit1.getValue() + unit2.getValue();
        }
        throw new QuantityMeasurementException(UNITS_MISMATCH);
    }
}
