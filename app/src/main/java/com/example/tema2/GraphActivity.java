package com.example.tema2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.tema2.classes.GraphView;
import com.example.tema2.classes.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphActivity extends AppCompatActivity {

    public static final String TEST_KEY = "testKey";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        List<Test> tests = (List<Test>) getIntent().getSerializableExtra(TEST_KEY);
        setContentView(new GraphView(getApplicationContext(),getSource(tests)));
    }

    private Map<String,Integer> getSource(List<Test> tests) {
        if(tests == null || tests.isEmpty()){
            return new HashMap<>();
        }
        Map<String,Integer> source = new HashMap<>();
        for(Test test: tests){
            if(source.containsKey(test.getMedicalCenter())){
                Integer currentValue = source.get(test.getMedicalCenter());
                source.put(test.getMedicalCenter(),currentValue+1);
            }else{
                source.put(test.getMedicalCenter(),1);
            }
        }
        return source;
    }
}