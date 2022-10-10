package com.example.tema2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.tema2.async.Callback;
import com.example.tema2.classes.MedicalCenter;
import com.example.tema2.classes.MedicalCenterAdapter;
import com.example.tema2.classes.TestAdapter;
import com.example.tema2.database.MedicalCenterService;

import java.util.ArrayList;
import java.util.List;

public class MedicalCentersActivity extends AppCompatActivity {

     private ListView medicalCenterslv;
     private List<MedicalCenter> medicalCenters = new ArrayList<>();
     private Button addBtn;
     private ActivityResultLauncher<Intent> addMedicalCenterLauncher;
     private MedicalCenterService medicalCenterService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_centers);
        setInit();
        addMedicalCenterLauncher = registerLauncher();
        medicalCenterService = new MedicalCenterService(getApplicationContext());
        medicalCenterService.getAll(getAllMedicalCentersCallback());

    }

    private Callback<List<MedicalCenter>> getAllMedicalCentersCallback() {
        return new Callback<List<MedicalCenter>>() {
            @Override
            public void runResultOnUiThread(List<MedicalCenter> results) {
                if(results != null){
                    medicalCenters.clear();
                    medicalCenters.addAll(results);
                    ArrayAdapter adapter = (ArrayAdapter) medicalCenterslv.getAdapter();
                    adapter.notifyDataSetChanged();
                }
            }
        };
    }

    private void setInit() {

        medicalCenterslv = findViewById(R.id.sandu_cristina_alexandra_mc_lv);
        addBtn = findViewById(R.id.sandu_cristina_alexandra_mc_btn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AddCentersActivity.class);
                //startActivity(intent);
                addMedicalCenterLauncher.launch(intent);
            }
        });
        addMedicalCenterAdapter();
    }


    private void addMedicalCenterAdapter() {

        MedicalCenterAdapter adapter = new MedicalCenterAdapter(getApplicationContext(),R.layout.medical_centers_adapter_view, medicalCenters,getLayoutInflater());
        medicalCenterslv.setAdapter(adapter);
    }

    private ActivityResultLauncher<Intent> registerLauncher() {
        ActivityResultCallback<ActivityResult> callback = addCallback();
        return registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),callback);
    }

    private ActivityResultCallback<ActivityResult> addCallback(){
        return new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                      if(result.getResultCode() == RESULT_OK && result.getData()!=null){
                          MedicalCenter medicalCenter = (MedicalCenter) result.getData().getSerializableExtra(AddCentersActivity.ADD_CENTER_KEY);
                          //inserare in baza de date
                          medicalCenterService.insert(medicalCenter,insertMedicalCenterCallback());

                      }
            }
        };
    }

    private Callback<MedicalCenter> insertMedicalCenterCallback() {
        return new Callback<MedicalCenter>() {
            @Override
            public void runResultOnUiThread(MedicalCenter medicalCenter) {
                if(medicalCenter != null){
                    medicalCenters.add(medicalCenter);
                    ArrayAdapter adapter = (ArrayAdapter) medicalCenterslv.getAdapter();
                    adapter.notifyDataSetChanged();
                }
            }
        };
    }


}