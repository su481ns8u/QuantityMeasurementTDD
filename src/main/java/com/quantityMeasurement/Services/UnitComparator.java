package com.quantityMeasurement.Services;

import com.quantityMeasurement.Exceptions.QuantityMeasurementException;
import com.quantityMeasurement.Utilities.UnitCreatorFactory;

import static com.quantityMeasurement.Exceptions.QuantityMeasurementException.ExceptionType.NO_UNIT_FOUND;

public class UnitComparator {
    public boolean compare(UnitCreatorFactory unit1, UnitCreatorFactory unit2) throws QuantityMeasurementException {
        if (unit1 == null || unit2 == null)
            throw new QuantityMeasurementException(NO_UNIT_FOUND, NO_UNIT_FOUND.message);
        return unit1.equals(unit2);
    }
}
