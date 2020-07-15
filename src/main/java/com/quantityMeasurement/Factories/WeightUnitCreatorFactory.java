package com.quantityMeasurement.Factories;

import com.quantityMeasurement.Exceptions.QuantityMeasurementException;
import com.quantityMeasurement.Utilities.IUnitsCreatorFactory;
import com.quantityMeasurement.Utilities.Units;

import static com.quantityMeasurement.Exceptions.QuantityMeasurementException.ExceptionType.NEGATIVE_VALUE;
import static com.quantityMeasurement.Exceptions.QuantityMeasurementException.ExceptionType.UNIT_NOT_ACCEPTED;
import static com.quantityMeasurement.Utilities.Units.*;

public class WeightUnitCreatorFactory implements IUnitsCreatorFactory {
    private Units unit;
    private double value;

    public WeightUnitCreatorFactory(double value, Units unit) throws QuantityMeasurementException {
        if (value < 0) throw new QuantityMeasurementException(NEGATIVE_VALUE);
        if (unit != KG && unit != GRAM && unit != TONS)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeightUnitCreatorFactory that = (WeightUnitCreatorFactory) o;
        return Double.compare(that.value, value) == 0;
    }
}