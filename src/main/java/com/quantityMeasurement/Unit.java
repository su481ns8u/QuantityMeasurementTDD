package com.quantityMeasurement;

public enum Unit {
    FEET(12),
    INCH(1);

    double value;

    Unit(double value) {
        this.value = value;
    }
}
