package com.example.tema2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.tema2.classes.MedicalCenter;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class AddCentersActivity extends AppCompatActivity {
    public static final String ADD_CENTER_KEY = "ADD_CENTER_KEY";
    private Button addInList;
    private TextInputEditText nametiet;
    private TextInputEditText locationtiet;
    private TextInputEditText nrTeststiet;
    private TextInputEditText nrEmployeestiet;
    private TextInputEditText contacttiet;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_centers);
        setInit();
        intent = getIntent();

    }

    private void setInit() {
        nametiet = findViewById(R.id.sandu_cristina_alexandra_add_tiet_name);
        locationtiet = findViewById(R.id.sandu_cristina_alexandra_add_tiet_location);
        nrTeststiet = findViewById(R.id.sandu_cristina_alexandra_add_tiet_number_tests);
        nrEmployeestiet = findViewById(R.id.sandu_cristina_alexandra_add_tiet_number_employees);
        contacttiet = findViewById(R.id.sandu_cristina_alexandra_add_tiet_contact_number);
        addInList = findViewById(R.id.sandu_cristina_alexandra_add_center_btn);
        addInList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isValid()){
                    MedicalCenter medicalCenter = buildMedicalCenter();
                    intent.putExtra(ADD_CENTER_KEY,medicalCenter);
                    setResult(RESULT_OK,intent);
                    finish();
                }
            }
        });

    }

    private MedicalCenter buildMedicalCenter() {
        String name = nametiet.getText().toString();
        String location = locationtiet.getText().toString();
        int nrTests = Integer.parseInt(nrTeststiet.getText().toString().trim());
        int nrEmployees = Integer.parseInt(nrEmployeestiet.getText().toString().trim());
        String contactNumber = contacttiet.getText().toString();
        return new MedicalCenter(name,location,nrTests,nrEmployees,contactNumber);
    }

    private boolean isValid() {
        if(nametiet.getText() == null || nametiet.getText().toString().trim().length() < 3){
            Toast.makeText(getApplicationContext(),R.string.name_tiet_val,Toast.LENGTH_LONG).show();
            return false;
        }
        if(locationtiet.getText() == null || locationtiet.getText().toString().trim().length() < 3){
            Toast.makeText(getApplicationContext(),R.string.location_tiet_val,Toast.LENGTH_LONG).show();
            return false;
        }
        if(nrTeststiet.getText() == null || nrTeststiet.getText().toString().trim().isEmpty()
                || Integer.parseInt(nrTeststiet.getText().toString().trim()) < 0){
            Toast.makeText(getApplicationContext(),R.string.nrtests_tiet_val,Toast.LENGTH_LONG).show();
            return false;
        }
        if(nrEmployeestiet.getText() == null || nrEmployeestiet.getText().toString().trim().isEmpty()
                || Integer.parseInt(nrEmployeestiet.getText().toString().trim()) < 10){
            Toast.makeText(getApplicationContext(),R.string.nremployees_tiet_val,Toast.LENGTH_LONG).show();
            return false;
        }
        if(contacttiet.getText() == null || contacttiet.getText().toString().trim().length() != 10){
            Toast.makeText(getApplicationContext(),R.string.contact_tiet_val,Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
}