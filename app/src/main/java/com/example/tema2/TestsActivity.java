package com.example.tema2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tema2.classes.Adress;
import com.example.tema2.classes.Patient;
import com.example.tema2.classes.Test;
import com.example.tema2.classes.TestAdapter;
import com.example.tema2.classes.TestsJsonParser;
import com.example.tema2.network.HttpManager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TestsActivity extends AppCompatActivity {
    private ListView lv;
    private List<Test> tests = new ArrayList<>();
    private static final String TESTS_URL = "https://jsonkeeper.com/b/TZKT";
    private FloatingActionButton fabGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests);
        setInit();
        //tests.add(new Test("dkhfgke","egdewi",false,"dhfgs",new Patient("fehkfu",29,"eygwuyd",new Adress("kwegd","wkdgk","wdyg",23))));
        loadTestsFromUrl();
    }

    private void loadTestsFromUrl() {

        Thread thread = new Thread(){
            @Override
            public void run() {
                HttpManager manager = new HttpManager(TESTS_URL);
                String result = manager.process();
                new Handler(getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        mainThreadGetTestsCallback(result);
                    }
                });
            }
        };
        thread.start();
    }

    private void mainThreadGetTestsCallback(String result){
        //Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
        tests.addAll(TestsJsonParser.fromJson(result));
        notifyAdapter();
    }

    private void setInit() {
        lv = findViewById(R.id.sandu_cristina_alexandra_tests_lv);
        addTestsAdapter();
        fabGraph = findViewById(R.id.sandu_cristina_alexandra_fab_graph);
        fabGraph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),GraphActivity.class);
                intent.putExtra(GraphActivity.TEST_KEY, (Serializable) tests);
                startActivity(intent);
            }
        });
    }

    private void addTestsAdapter() {
        TestAdapter adapter = new TestAdapter(getApplicationContext(),R.layout.test_adapter_view,tests,getLayoutInflater());
        lv.setAdapter(adapter);
    }

    private void notifyAdapter(){
        TestAdapter adapter = (TestAdapter) lv.getAdapter();
        adapter.notifyDataSetChanged();
    }
}