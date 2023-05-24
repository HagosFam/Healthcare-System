package com.healthcare.prescriptionmanagement.proxy;

public class PatientErrorType {

    private String errorMessage;

    public PatientErrorType(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
