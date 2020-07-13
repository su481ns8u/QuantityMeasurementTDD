package com.quantityMeasurement;

import static com.quantityMeasurement.QuantityMeasurementException.ExceptionType.*;

public class UnitComparator {
    public boolean compare(UnitCreatorFactory unit1, UnitCreatorFactory unit2) throws QuantityMeasurementException {
        if (unit1 == null || unit2 == null)
            throw new QuantityMeasurementException(NO_UNIT_FOUND, NO_UNIT_FOUND.message);
        return unit1.equals(unit2);
    }
}
