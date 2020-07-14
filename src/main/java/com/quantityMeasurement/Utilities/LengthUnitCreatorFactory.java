package com.quantityMeasurement.Utilities;

public class UnitCreatorFactory {
    private final Unit unit;
    private final double value;

    public UnitCreatorFactory(double value, Unit unit) {
        this.value = value * unit.value;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnitCreatorFactory that = (UnitCreatorFactory) o;
        return Double.compare(that.value, value) == 0;
    }
}