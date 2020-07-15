package com.quantityMeasurement.Factories;

import com.quantityMeasurement.Exceptions.QuantityMeasurementException;
import com.quantityMeasurement.Utilities.Unit;
import com.quantityMeasurement.Utilities.Units;

import java.util.Objects;

import static com.quantityMeasurement.Exceptions.QuantityMeasurementException.ExceptionType.NEGATIVE_VALUE;

public class VolumeUnitCreatorFactory implements Units {
    private Unit unit;
    private double value;

    /**
     * Method to create value unit pairs
     *
     * @param value
     * @param unit
     * @throws QuantityMeasurementException
     */
    public VolumeUnitCreatorFactory(double value, Unit unit) throws QuantityMeasurementException {
        if (value < 0) throw new QuantityMeasurementException(NEGATIVE_VALUE);
//        if (unit != INCH || unit != FEET || unit != CM || unit != YARD)
//            throw new QuantityMeasurementException(UNIT_NOT_ACCEPTED);
        this.value = value * unit.conversionFactor;
        this.unit = unit;
    }

    @Override
    public double getValue() {
        return 0;
    }

    @Override
    public Unit getUnit() {
        return null;
    }

    @Override
    public void convert(Unit unit) {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VolumeUnitCreatorFactory that = (VolumeUnitCreatorFactory) o;
        return Double.compare(that.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(unit, value);
    }
}
