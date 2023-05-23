package PrescriptionManagement.Prescription.domain;

public class DosageErrorType {

    private String errorMessage;

    public DosageErrorType(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
