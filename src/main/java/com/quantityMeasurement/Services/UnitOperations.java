package com.quantityMeasurement.Services;

import com.quantityMeasurement.Exceptions.QuantityMeasurementException;
import com.quantityMeasurement.Utilities.LengthUnitCreatorFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.quantityMeasurement.Exceptions.QuantityMeasurementException.ExceptionType.INVALID_ARGUMENTS;

public class UnitComparator {
    /**
     * Method to compare values and units
     *
     * @param unit
     * @return
     * @throws QuantityMeasurementException
     */
    public boolean compare(LengthUnitCreatorFactory... unit) throws QuantityMeasurementException {
        List<LengthUnitCreatorFactory> list = Arrays.asList(unit);
        if (list.size() <= 1 || list.contains(null))
            throw new QuantityMeasurementException(INVALID_ARGUMENTS);
        return Collections.frequency(list, list.get(0)) == list.size();
    }
}
