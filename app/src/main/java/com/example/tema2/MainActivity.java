package com.example.tema2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private Button medicalbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setInit();
    }
    private void setInit(){
        btn = findViewById(R.id.sandu_cristina_alexandra_main_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),TestsActivity.class);
                startActivity(intent);
            }
        });
        medicalbtn = findViewById(R.id.sandu_cristina_alexandra_main_btn_lista_centre);
        medicalbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MedicalCentersActivity.class);
                startActivity(intent);
            }
        });
    }
}