package com.healthcare.prescriptionmanagement.domain;

public class PrescriptionErrorType {

    private String errorMessage;

    public PrescriptionErrorType(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
