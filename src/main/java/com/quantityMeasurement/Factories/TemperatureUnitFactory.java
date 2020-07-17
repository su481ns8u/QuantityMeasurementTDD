package com.quantityMeasurement.Factories;

import com.quantityMeasurement.Exceptions.QuantityMeasurementException;
import com.quantityMeasurement.Utilities.Units;

import static com.quantityMeasurement.Exceptions.QuantityMeasurementException.ExceptionType.UNIT_NOT_ACCEPTED;
import static com.quantityMeasurement.Utilities.Units.CELSIUS;
import static com.quantityMeasurement.Utilities.Units.FAHRENHEIT;

public class TemperatureUnitFactory implements IUnitsFactory {
    private Units unit;
    private double value;

    public TemperatureUnitFactory(double value, Units unit) throws QuantityMeasurementException {
        if (unit != CELSIUS && unit != FAHRENHEIT) throw new QuantityMeasurementException(UNIT_NOT_ACCEPTED);
        this.value = value;
        this.unit = unit;
    }

    @Override
    public void convertToBase() {
        if (this.unit == FAHRENHEIT) this.value = (value - 32) * unit.conversionFactor;
        this.unit = CELSIUS;
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
        TemperatureUnitFactory that = (TemperatureUnitFactory) o;
        return Double.compare(that.value, value) == 0 && this.unit == that.unit;
    }
}
