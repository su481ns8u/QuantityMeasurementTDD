package com.quantityMeasurement;

public enum Unit {
    FEET(1),
    INCH(12);

    double value;

    Unit(double value) {
        this.value = value;
    }
}
