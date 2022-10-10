package com.example.tema2.classes;

import com.example.tema2.classes.Adress;

import java.io.Serializable;

public class Patient implements Serializable{
    private String name;
    private int age;
    private String gender;
    private Adress adress;

    public Patient(String name, int age, String gender, Adress adress) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", adress=" + adress +
                '}';
    }
}
