package com.quantityMeasurement.Services;

import com.quantityMeasurement.Exceptions.QuantityMeasurementException;
import com.quantityMeasurement.Utilities.LengthUnitCreatorFactory;
import com.quantityMeasurement.Utilities.Unit;

import static com.quantityMeasurement.Exceptions.QuantityMeasurementException.ExceptionType.NULL_UNIT;

public class UnitComparator {
    public boolean compare(LengthUnitCreatorFactory unit1, LengthUnitCreatorFactory unit2) throws QuantityMeasurementException {
        if (unit1 == null || unit2 == null)
            throw new QuantityMeasurementException(NULL_UNIT);
        return unit1.equals(unit2);
    }
}
