package com.quantityMeasurement;

public class QuantityMeasurementException extends Throwable {
    public enum ExceptionType {
        NO_UNIT_FOUND("Two Units Expected !");

        String message;

        ExceptionType(String message){
            this.message = message;
        }
    }

    public ExceptionType type;

    public QuantityMeasurementException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}
