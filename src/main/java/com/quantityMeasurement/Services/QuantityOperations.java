package com.quantityMeasurement.Services;

import com.quantityMeasurement.Exceptions.QuantityMeasurementException;
import com.quantityMeasurement.Factories.IUnitsFactory;

import static com.quantityMeasurement.Exceptions.QuantityMeasurementException.ExceptionType.UNITS_MISMATCH;

public class QuantityOperations {
    /**
     * Function to compare two units are same or not
     *
     * @param unit1 contains unit1
     * @param unit2 contains unit2
     * @return True if both units are turned into same or False otherwise
     * @throws QuantityMeasurementException either any exception occurs
     */
    public boolean compare(IUnitsFactory unit1, IUnitsFactory unit2) throws QuantityMeasurementException {
        if (unit1 == null || unit2 == null)
            throw new QuantityMeasurementException(QuantityMeasurementException.ExceptionType.INVALID_ARGUMENTS);
        unit1.convertToBase();
        unit2.convertToBase();
        return unit1.equals(unit2);
    }

    /**
     * Function to add two units if they are of same class
     *
     * @param unit1 contains unit1
     * @param unit2 contains unit2
     * @return addition of two units
     * @throws QuantityMeasurementException if units mismatch or wrong units
     */
    public double addUnits(IUnitsFactory unit1, IUnitsFactory unit2) throws QuantityMeasurementException {
        if (unit1.getClass() == unit2.getClass()) {
            unit1.convertToBase();
            unit2.convertToBase();
            return unit1.getValue() + unit2.getValue();
        }
        throw new QuantityMeasurementException(UNITS_MISMATCH);
    }
}
