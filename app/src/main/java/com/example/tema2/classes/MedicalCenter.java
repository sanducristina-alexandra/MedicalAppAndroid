package com.example.tema2.classes;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "Medical Centers")
public class MedicalCenter implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    private long id;

    @ColumnInfo(name = "Name")
    private String name;
    @ColumnInfo(name = "Location")
    private String location;
    @ColumnInfo(name = "Number of tests")
    private int numberOfTests;
    @ColumnInfo(name = "Number of employees")
    private int numberOfEmployees;
    @ColumnInfo(name = "Contact Number")
    private String contactNumber;

    public MedicalCenter(long id, String name, String location, int numberOfTests, int numberOfEmployees, String contactNumber) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.numberOfTests = numberOfTests;
        this.numberOfEmployees = numberOfEmployees;
        this.contactNumber = contactNumber;
    }

    @Ignore
    public MedicalCenter(String name, String location, int numberOfTests, int numberOfEmployees, String contactNumber) {
        this.name = name;
        this.location = location;
        this.numberOfTests = numberOfTests;
        this.numberOfEmployees = numberOfEmployees;
        this.contactNumber = contactNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNumberOfTests() {
        return numberOfTests;
    }

    public void setNumberOfTests(int numberOfTests) {
        this.numberOfTests = numberOfTests;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "MedicalCenter{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", numberOfTests=" + numberOfTests +
                ", numberOfEmployees=" + numberOfEmployees +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}
