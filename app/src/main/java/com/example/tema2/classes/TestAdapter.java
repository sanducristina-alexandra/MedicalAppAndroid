package com.example.tema2.classes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.tema2.R;
import com.example.tema2.classes.Test;

import java.util.List;

public class TestAdapter extends ArrayAdapter<Test> {
    private Context context;
    private int resource;
    private List<Test> tests;
    private LayoutInflater inflater;

    public TestAdapter(@NonNull Context context, int resource, @NonNull List<Test> objects,LayoutInflater inflater) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.tests = objects;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = inflater.inflate(resource,parent,false);
        Test test = tests.get(position);
        if(test == null){
            return view;
        }
        addPatientName(view,test.getPatient().getName());
        addResult(view,test.isResult());
        addCompany(view,test.getCompany());
        addType(view,test.getType());
        addMedicalCenter(view,test.getMedicalCenter());
        return view;
    }

    private void addMedicalCenter(View view, String medicalCenter) {
        TextView textView = view.findViewById(R.id.sandu_cristina_alexandra_tadapter_medical_center);
        populateContent(textView,medicalCenter);
    }

    private void addType(View view, String type) {
        TextView textView = view.findViewById(R.id.sandu_cristina_alexandra_tadapter_type);
        populateContent(textView,type);
    }

    private void addCompany(View view, String company) {
        TextView textView = view.findViewById(R.id.sandu_cristina_alexandra_tadapter_company);
        populateContent(textView,company);
    }

    private void addResult(View view, boolean result) {
        TextView textView = view.findViewById(R.id.sandu_cristina_alexandra_tadapter_result);
        populateContent(textView,String.valueOf(result));
    }

    private void addPatientName(View view, String name) {
        TextView textView = view.findViewById(R.id.sandu_cristina_alexandra_tadapter_pacient_name);
        populateContent(textView,name);
    }

    private void populateContent(TextView textView,String value){
        if(value!=null && !value.trim().isEmpty()){
            textView.setText(value);
        }else{
            textView.setText(R.string.empty);
        }
    }
}
