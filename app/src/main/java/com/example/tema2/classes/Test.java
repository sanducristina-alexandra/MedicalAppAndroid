package com.example.tema2.classes;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.tema2.classes.Patient;

import java.io.Serializable;

public class Test implements Serializable{
    private String company;
    private String type;
    private boolean result;
    private String medicalCenter;
    private Patient patient;


    public Test(String company, String type, boolean result, String medicalCenter, Patient patient) {
        this.company = company;
        this.type = type;
        this.result = result;
        this.medicalCenter = medicalCenter;
        this.patient = patient;
    }

    public Test(String company, String type, boolean result, String medicalCenter) {
        this.company = company;
        this.type = type;
        this.result = result;
        this.medicalCenter = medicalCenter;
    }

    public String getCompany() {
        return company;
    }

    public String getType() {
        return type;
    }

    public boolean isResult() {
        return result;
    }

    public String getMedicalCenter() {
        return medicalCenter;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public void setMedicalCenter(String medicalCenter) {
        this.medicalCenter = medicalCenter;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Test{" +
                "company='" + company + '\'' +
                ", type='" + type + '\'' +
                ", result=" + result +
                ", medicalCenter='" + medicalCenter + '\'' +
                ", patient=" + patient +
                '}';
    }

}
