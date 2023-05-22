package com.healthcare.billingandpayment.controller;

public class CustomErrorMessage {
    private String message;

    public CustomErrorMessage(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return message;
    }
}
