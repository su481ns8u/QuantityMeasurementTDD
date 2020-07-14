package com.quantityMeasurement.Utilities;

public enum Unit {
    FEET(12),
    INCH(1),
    YARD(36),
    CM(0.4);

    public double conversionFactor;

    Unit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }
}
