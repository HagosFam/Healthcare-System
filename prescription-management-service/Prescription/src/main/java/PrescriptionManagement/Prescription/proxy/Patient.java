package PrescriptionManagement.Prescription.proxy;

import org.springframework.data.annotation.Id;


import java.util.Date;


public class Patient {


@Id
private long patientId;
private String patientname;
private Date dob;
private String phoneNumber;

private Address address;

public Patient(){

}

    public Patient(long patientId, String patientname, Date dob, String phoneNumber) {
        this.patientId = patientId;
        this.patientname = patientname;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public String getPatientname() {
        return patientname;
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", patientname='" + patientname + '\'' +
                ", dob=" + dob +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address=" + address +
                '}';
    }
}
