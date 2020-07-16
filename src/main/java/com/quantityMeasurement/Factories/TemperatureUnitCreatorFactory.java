package com.quantityMeasurement.Factories;

import com.quantityMeasurement.Exceptions.QuantityMeasurementException;
import com.quantityMeasurement.Utilities.IUnitsCreatorFactory;
import com.quantityMeasurement.Utilities.Units;

import static com.quantityMeasurement.Exceptions.QuantityMeasurementException.ExceptionType.NEGATIVE_VALUE;
import static com.quantityMeasurement.Exceptions.QuantityMeasurementException.ExceptionType.UNIT_NOT_ACCEPTED;
import static com.quantityMeasurement.Utilities.Units.CELSIUS;
import static com.quantityMeasurement.Utilities.Units.FAHRENHEIT;

public class TemperatureUnitCreatorFactory implements IUnitsCreatorFactory {
    private Units unit;
    private double value;

    /**
     * Method to create value unit pairs
     *
     * @param value
     * @param unit
     * @throws QuantityMeasurementException
     */
    public TemperatureUnitCreatorFactory(double value, Units unit) throws QuantityMeasurementException {
        if (value < 0) throw new QuantityMeasurementException(NEGATIVE_VALUE);
        if (unit != CELSIUS && unit != FAHRENHEIT) throw new QuantityMeasurementException(UNIT_NOT_ACCEPTED);
        this.value = value;
        this.unit = unit;
    }

    @Override
    public void convert(Units unit) throws QuantityMeasurementException {
        if (unit != CELSIUS && unit != FAHRENHEIT) throw new QuantityMeasurementException(UNIT_NOT_ACCEPTED);
        if (this.unit == CELSIUS && unit == FAHRENHEIT) this.value = (value * 9 / 5) + 32;
        if (this.unit == FAHRENHEIT && unit == CELSIUS) this.value = (value - 32) * 5 / 9;
        this.unit = unit;
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TemperatureUnitCreatorFactory that = (TemperatureUnitCreatorFactory) o;
        return Double.compare(that.value, value) == 0;
    }
}
