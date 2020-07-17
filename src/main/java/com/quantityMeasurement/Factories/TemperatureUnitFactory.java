package com.quantityMeasurement.Factories;

import com.quantityMeasurement.Exceptions.QuantityMeasurementException;
import com.quantityMeasurement.Enums.Units;

import static com.quantityMeasurement.Exceptions.QuantityMeasurementException.ExceptionType.UNIT_NOT_ACCEPTED;
import static com.quantityMeasurement.Enums.Units.CELSIUS;
import static com.quantityMeasurement.Enums.Units.FAHRENHEIT;

public class TemperatureUnitFactory implements IUnitsFactory {
    /* Unit parameters */
    private Units unit;
    private double value;

    /**
     * Set value and unit parameters
     *
     * @param value contains a double value
     * @param unit  contains unit for the value
     * @throws QuantityMeasurementException if value is in negative or unit is not accepted
     */
    public TemperatureUnitFactory(double value, Units unit) throws QuantityMeasurementException {
        if (unit != CELSIUS && unit != FAHRENHEIT) throw new QuantityMeasurementException(UNIT_NOT_ACCEPTED);
        this.value = value;
        this.unit = unit;
    }

    /* @returns value */
    @Override
    public double getValue() {
        return value;
    }

    /**
     * Set the base unit and value
     */
    @Override
    public void convertToBase() {
        if (this.unit == FAHRENHEIT) this.value = (value - 32) * unit.conversionFactor;
        this.unit = CELSIUS;
    }

    /**
     * Check for equality of this class and entered object
     *
     * @param o is the object of same class
     * @return true if this and o is same
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TemperatureUnitFactory that = (TemperatureUnitFactory) o;
        return Double.compare(that.value, value) == 0 && this.unit == that.unit;
    }
}
