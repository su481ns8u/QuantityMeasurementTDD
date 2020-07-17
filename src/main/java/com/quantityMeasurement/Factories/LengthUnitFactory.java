package com.quantityMeasurement.Factories;

import com.quantityMeasurement.Exceptions.QuantityMeasurementException;
import com.quantityMeasurement.Utilities.Units;

import static com.quantityMeasurement.Exceptions.QuantityMeasurementException.ExceptionType.NEGATIVE_VALUE;
import static com.quantityMeasurement.Exceptions.QuantityMeasurementException.ExceptionType.UNIT_NOT_ACCEPTED;
import static com.quantityMeasurement.Utilities.Units.*;

public class LengthUnitFactory implements IUnitsFactory {
    private Units unit;
    private double value;

    public LengthUnitFactory(double value, Units unit) throws QuantityMeasurementException {
        if (value < 0) throw new QuantityMeasurementException(NEGATIVE_VALUE);
        if (unit != INCH && unit != FEET && unit != CM && unit != YARD)
            throw new QuantityMeasurementException(UNIT_NOT_ACCEPTED);
        this.value = value;
        this.unit = unit;
    }

    @Override
    public void convertToBase() {
        this.value = this.value * this.unit.conversionFactor;
        this.unit = INCH;
    }

    @Override
    public Units getUnit() {
        return this.unit;
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LengthUnitFactory that = (LengthUnitFactory) o;
        return Double.compare(that.value, value) == 0 && this.unit == that.unit;
    }
}