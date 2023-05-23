package PrescriptionManagement.Prescription.domain;

import jakarta.persistence.Entity;


public enum PrescriptionStatus {
    PENDING("Pending"),
    FILLED("Filled"),
    CANCELED("Canceled");

    private final String displayName;

    PrescriptionStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public boolean isPending() {
        return this == PENDING;
    }

    public boolean isFilled() {
        return this == FILLED;
    }

    public boolean isCanceled() {
        return this == CANCELED;
    }
}
