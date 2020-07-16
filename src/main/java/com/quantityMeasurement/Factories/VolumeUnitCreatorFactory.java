package com.quantityMeasurement.Factories;

import com.quantityMeasurement.Exceptions.QuantityMeasurementException;
import com.quantityMeasurement.Utilities.IUnitsCreatorFactory;
import com.quantityMeasurement.Utilities.Units;

import static com.quantityMeasurement.Exceptions.QuantityMeasurementException.ExceptionType.NEGATIVE_VALUE;
import static com.quantityMeasurement.Exceptions.QuantityMeasurementException.ExceptionType.UNIT_NOT_ACCEPTED;
import static com.quantityMeasurement.Utilities.Units.*;

public class VolumeUnitCreatorFactory implements IUnitsCreatorFactory {
    private Units unit;
    private double value;

    /**
     * Method to create value unit pairs
     *
     * @param value
     * @param unit
     * @throws QuantityMeasurementException
     */
    public VolumeUnitCreatorFactory(double value, Units unit) throws QuantityMeasurementException {
        if (value < 0) throw new QuantityMeasurementException(NEGATIVE_VALUE);
        if (unit != LITRE && unit != MILLI_LITER && unit != GALLON)
            throw new QuantityMeasurementException(UNIT_NOT_ACCEPTED);
        this.value = value * unit.conversionFactor;
        this.unit = unit;
    }

    @Override
    public double getValue() {
        return this.value;
    }

    @Override
    public void convert(Units unit) throws QuantityMeasurementException {
        if (unit != LITRE && unit != MILLI_LITER && unit != GALLON)
            throw new QuantityMeasurementException(UNIT_NOT_ACCEPTED);
        this.value = value / unit.conversionFactor;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VolumeUnitCreatorFactory that = (VolumeUnitCreatorFactory) o;
        return Double.compare(that.value, value) == 0;
    }
}
