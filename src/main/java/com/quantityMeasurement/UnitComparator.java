package com.quantityMeasurement;

public class UnitComparator {
    double value;
    public boolean compare(Unit unit1, Unit unit2) {
        if (unit1.equals(unit2))
            return true;
        return false;
    }
}
