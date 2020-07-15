package com.quantityMeasurement.Exceptions;

public class QuantityMeasurementException extends Throwable {
    public enum ExceptionType {
        NULL_UNIT("Comparision Expects two arguments!"),
        NEGATIVE_VALUE("Negative value not accepted");

        public String message;

        ExceptionType(String message){
            this.message = message;
        }
    }

    public ExceptionType type;

    public QuantityMeasurementException(ExceptionType type) {
        super(type.message);
        this.type = type;
    }
}
