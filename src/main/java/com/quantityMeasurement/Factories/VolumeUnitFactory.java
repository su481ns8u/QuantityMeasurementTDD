package com.quantityMeasurement.Factories;

import com.quantityMeasurement.Exceptions.QuantityMeasurementException;
import com.quantityMeasurement.Enums.Units;

import static com.quantityMeasurement.Exceptions.QuantityMeasurementException.ExceptionType.NEGATIVE_VALUE;
import static com.quantityMeasurement.Exceptions.QuantityMeasurementException.ExceptionType.UNIT_NOT_ACCEPTED;
import static com.quantityMeasurement.Enums.Units.*;

public class VolumeUnitFactory implements IUnitsFactory {
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
    public VolumeUnitFactory(double value, Units unit) throws QuantityMeasurementException {
        if (value < 0) throw new QuantityMeasurementException(NEGATIVE_VALUE);
        if (unit != LITRE && unit != MILLI_LITER && unit != GALLON)
            throw new QuantityMeasurementException(UNIT_NOT_ACCEPTED);
        this.value = value;
        this.unit = unit;
    }

    /* @returns value */
    @Override
    public double getValue() {
        return this.value;
    }

    /**
     * Set the base unit and value
     */
    @Override
    public void convertToBase() {
        this.value = value * unit.conversionFactor;
        this.unit = LITRE;
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
        VolumeUnitFactory that = (VolumeUnitFactory) o;
        return Double.compare(that.value, value) == 0 && this.unit == that.unit;
    }
}
