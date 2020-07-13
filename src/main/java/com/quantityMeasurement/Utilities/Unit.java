package com.quantityMeasurement.Utilities;

public enum Unit {
    FEET(12),
    INCH(1),
    YARD(36);

    double value;

    Unit(double value) {
        this.value = value;
    }
}
