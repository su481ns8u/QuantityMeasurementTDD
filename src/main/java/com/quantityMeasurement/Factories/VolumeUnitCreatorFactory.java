package com.quantityMeasurement.Factories;

import com.quantityMeasurement.Exceptions.QuantityMeasurementException;
import com.quantityMeasurement.Utilities.Unit;
import com.quantityMeasurement.Utilities.Units;

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
        return this.value;
    }

    @Override
    public Unit getUnit() {
        return this.unit;
    }

    @Override
    public void convert(Unit unit) {
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
