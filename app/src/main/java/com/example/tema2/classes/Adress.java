package com.example.tema2.classes;

import java.io.Serializable;

public class Adress implements Serializable{
    private String county;
    private String city;
    private String street;
    private int number;

    public Adress(String county, String city, String street, int number) {
        this.county = county;
        this.city = city;
        this.street = street;
        this.number = number;
    }

    public String getCounty() {
        return county;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getNumber() {
        return number;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "county='" + county + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", number=" + number +
                '}';
    }
}
