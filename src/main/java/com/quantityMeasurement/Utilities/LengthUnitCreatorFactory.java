package com.quantityMeasurement.Utilities;

import com.quantityMeasurement.Exceptions.QuantityMeasurementException;

import static com.quantityMeasurement.Exceptions.QuantityMeasurementException.ExceptionType.NEGATIVE_VALUE;

public class LengthUnitCreatorFactory {
    public final Unit unit;
    public final double value;

    public LengthUnitCreatorFactory(double value, Unit unit) throws QuantityMeasurementException {
        if (value < 0) throw new QuantityMeasurementException(NEGATIVE_VALUE);
        this.value = value * unit.conversionFactor;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LengthUnitCreatorFactory that = (LengthUnitCreatorFactory) o;
        return Double.compare(that.value, value) == 0;
    }
}