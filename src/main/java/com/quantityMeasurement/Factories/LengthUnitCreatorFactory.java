package com.quantityMeasurement.Factories;

import com.quantityMeasurement.Exceptions.QuantityMeasurementException;
import com.quantityMeasurement.Utilities.IUnitsCreatorFactory;
import com.quantityMeasurement.Utilities.Units;

import static com.quantityMeasurement.Exceptions.QuantityMeasurementException.ExceptionType.NEGATIVE_VALUE;
import static com.quantityMeasurement.Exceptions.QuantityMeasurementException.ExceptionType.UNIT_NOT_ACCEPTED;
import static com.quantityMeasurement.Utilities.Units.*;

public class LengthUnitCreatorFactory implements IUnitsCreatorFactory {
    private Units unit;
    private double value;

    /**
     * Method to create value unit pairs
     *
     * @param value
     * @param unit
     * @throws QuantityMeasurementException
     */
    public LengthUnitCreatorFactory(double value, Units unit) throws QuantityMeasurementException {
        if (value < 0) throw new QuantityMeasurementException(NEGATIVE_VALUE);
        if (unit != INCH && unit != FEET && unit != CM && unit != YARD)
            throw new QuantityMeasurementException(UNIT_NOT_ACCEPTED);
        this.value = value * unit.conversionFactor;
        this.unit = unit;
    }

    @Override
    public void convert(Units unit) {
        this.value = value / unit.conversionFactor;
        this.unit = unit;
    }

    @Override
    public Units getUnit() {
        return unit;
    }

    @Override
    public double getValue() {
        return value;
    }

    /**
     * Method to check equality of two objects
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LengthUnitCreatorFactory that = (LengthUnitCreatorFactory) o;
        return Double.compare(that.value, value) == 0;
    }
}