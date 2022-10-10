package com.example.tema2.classes;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TestsJsonParser {
    public static final String COUNTY = "county";
    public static final String CITY = "city";
    public static final String STREET = "street";
    public static final String NUMBER = "number";
    public static final String NAME = "name";
    public static final String AGE = "age";
    public static final String GENDER = "gender";
    public static final String COMPANY = "company";
    public static final String TYPE = "type";
    public static final String RESULTS = "results";
    public static final String MEDICAL_CENTER = "medicalCenter";

    public static List<Test> fromJson(String json){
        try {
            JSONArray array = new JSONArray(json);
            return readTestsFromJson(array);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    private static List<Test> readTestsFromJson(JSONArray array) throws JSONException {
        List<Test> results = new ArrayList<>();
        for(int i=0;i<array.length();i++){
            JSONObject object = array.getJSONObject(i);
            Test test = readTestFromJson(object);
            results.add(test);
        }
        return results;
    }

    private static Test readTestFromJson(JSONObject object) throws JSONException {

        String company = object.getString(COMPANY);
        String type = object.getString(TYPE);
        boolean result = object.getBoolean(RESULTS);
        String medicalCenter = object.getString(MEDICAL_CENTER);
        JSONObject patient = object.getJSONObject("patient");

        String name = patient.getString(NAME);
        int age = patient.getInt(AGE);
        String gender = patient.getString(GENDER);

        JSONObject adress = patient.getJSONObject("adress");
        String county = adress.getString(COUNTY);
        String city = adress.getString(CITY);
        String street = adress.getString(STREET);
        int number = adress.getInt(NUMBER);

        Adress adress1 = new Adress(county,city,street,number);
        Patient patient1 = new Patient(name,age,gender,adress1);

        return new Test(company,type,result,medicalCenter,patient1);

    }
}
