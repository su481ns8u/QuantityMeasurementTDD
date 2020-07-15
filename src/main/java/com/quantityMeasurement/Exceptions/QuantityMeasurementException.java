package com.quantityMeasurement.Exceptions;

public class QuantityMeasurementException extends Throwable {
    public enum ExceptionType {
        INVALID_ARGUMENTS("Comparision Expects two or more not null arguments!"),
        NEGATIVE_VALUE("Negative value not accepted!"),
        UNITS_MISMATCH("Units must be of same type!"),
        UNIT_NOT_ACCEPTED("Given unit is not accepted in declared type!");

        public String message;

        ExceptionType(String message) {
            this.message = message;
        }
    }

    public ExceptionType type;

    public QuantityMeasurementException(ExceptionType type) {
        super(type.message);
        this.type = type;
    }
}
