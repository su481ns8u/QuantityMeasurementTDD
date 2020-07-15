package com.quantityMeasurement.Utilities;

public enum Unit {
    FEET(12),
    INCH(1),
    YARD(36),
    CM(2.0 / 5.0),

    LITRE(1),
    GALLON(3.78),
    MILLI_LITER(1.0 / 1000.0),

    KG(1),
    GRAM(1.0 / 1000.0),
    TONS(1000);

    public double conversionFactor;

    Unit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }
}
