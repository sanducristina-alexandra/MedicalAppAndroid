package com.example.tema2.database;

import android.content.Context;

import com.example.tema2.async.AsyncTaskRunner;
import com.example.tema2.async.Callback;
import com.example.tema2.classes.MedicalCenter;

import java.util.List;
import java.util.concurrent.Callable;


public class MedicalCenterService {
    private final MedicalCenterDao medicalCenterDao;
    private final AsyncTaskRunner asyncTaskRunner;

    public MedicalCenterService(Context context){
        this.medicalCenterDao = DatabaseManager.getInstance(context).getMedicalCenterDao();
        asyncTaskRunner = new AsyncTaskRunner();
    }

    public void insert(MedicalCenter medicalCenter, Callback<MedicalCenter> activityThread){
        Callable<MedicalCenter> insertOperation = new Callable<MedicalCenter>() {
            @Override
            public MedicalCenter call() {
                if(medicalCenter == null || medicalCenter.getId() > 0){
                    return null;
                }
                long id = medicalCenterDao.insert(medicalCenter);
                if(id<0){
                    return null;
                }
                medicalCenter.setId(id);
                return medicalCenter;
            }
        };
        asyncTaskRunner.executeAsync(insertOperation,activityThread);
    }

    public void getAll(Callback<List<MedicalCenter>> activityThread){
        Callable<List<MedicalCenter>> getAllOperation = new Callable<List<MedicalCenter>>() {
            @Override
            public List<MedicalCenter> call() {
                return medicalCenterDao.getAll();
            }
        };
        asyncTaskRunner.executeAsync(getAllOperation,activityThread);
    }
}
