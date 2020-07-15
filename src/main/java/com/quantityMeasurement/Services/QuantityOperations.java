package com.quantityMeasurement.Services;

import com.quantityMeasurement.Exceptions.QuantityMeasurementException;
import com.quantityMeasurement.Utilities.IUnitsCreatorFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.quantityMeasurement.Exceptions.QuantityMeasurementException.ExceptionType.INVALID_ARGUMENTS;
import static com.quantityMeasurement.Exceptions.QuantityMeasurementException.ExceptionType.UNITS_MISMATCH;

public class QuantityOperations {
    /**
     * Method to compare values and units
     *
     * @param unit
     * @return
     * @throws QuantityMeasurementException
     */
    public boolean compare(IUnitsCreatorFactory... unit) throws QuantityMeasurementException {
        List<IUnitsCreatorFactory> list = Arrays.asList(unit);
        if (list.size() <= 1 || list.contains(null))
            throw new QuantityMeasurementException(INVALID_ARGUMENTS);
        return Collections.frequency(list, list.get(0)) == list.size();
    }

    public double addUnits(IUnitsCreatorFactory unit1, IUnitsCreatorFactory unit2) throws QuantityMeasurementException {
        if (unit1.getClass().equals(unit2.getClass()))
            return unit1.getValue() + unit2.getValue();
        throw new QuantityMeasurementException(UNITS_MISMATCH);
    }
}
