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

import java.util.List;

public class MedicalCenterAdapter extends ArrayAdapter<MedicalCenter> {
    private Context context;
    private int resource;
    private List<MedicalCenter> medicalCenters;
    private LayoutInflater inflater;

    public MedicalCenterAdapter(@NonNull Context context, int resource, @NonNull List<MedicalCenter> objects,LayoutInflater inflater) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.medicalCenters = objects;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = inflater.inflate(resource,parent,false);
        MedicalCenter medicalCenter = medicalCenters.get(position);
        if(medicalCenter == null){
            return view;
        }
        addCenterName(view,medicalCenter.getName());
        addLocation(view,medicalCenter.getLocation());
        addNumberOfTests(view,medicalCenter.getNumberOfTests());
        addNumberOfEmployees(view,medicalCenter.getNumberOfEmployees());
        addContactNumber(view,medicalCenter.getContactNumber());
        return view;
    }

    private void addContactNumber(View view, String contactNumber) {
        TextView textView = view.findViewById(R.id.sandu_cristina_alexandra_mc_tv_contact_number);
        populateContent(textView,contactNumber);
    }

    private void addNumberOfEmployees(View view, int numberOfEmployees) {
        TextView textView = view.findViewById(R.id.sandu_cristina_alexandra_mc_tv_nr_employees);
        populateContent(textView,String.valueOf(numberOfEmployees));
    }

    private void addNumberOfTests(View view, int numberOfTests) {
        TextView textView = view.findViewById(R.id.sandu_cristina_alexandra_mc_tv_nr_tests);
        populateContent(textView,String.valueOf(numberOfTests));
    }

    private void addLocation(View view, String location) {
        TextView textView = view.findViewById(R.id.sandu_cristina_alexandra_mc_tv_location);
        populateContent(textView,location);
    }

    private void addCenterName(View view, String name) {
        TextView textView = view.findViewById(R.id.sandu_cristina_alexandra_mc_tv_name);
        populateContent(textView,name);
    }

    private void populateContent(TextView textView, String value){
        if(value!=null && !value.trim().isEmpty()){
            textView.setText(value);
        }else{
            textView.setText(R.string.empty);
        }
    }
}
