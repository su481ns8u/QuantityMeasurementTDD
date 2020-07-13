package com.quantityMeasurement;

import java.util.Objects;

public class Unit {
    double value;

    public Unit(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Unit unit = (Unit) o;
        return Double.compare(unit.value, value) == 0;
    }
}
