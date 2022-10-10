package com.example.tema2.database;

import android.content.Context;
import android.provider.ContactsContract;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.tema2.classes.MedicalCenter;

@Database(entities = {MedicalCenter.class},exportSchema = false,version = 1)
public abstract class DatabaseManager extends RoomDatabase {

    public static final String MEDICAL_CENTERS_DB = "Medical_Centers_db";
    private static DatabaseManager databaseManager;

    public static DatabaseManager getInstance(Context context){
        if(databaseManager == null){
            synchronized (DatabaseManager.class){
                if(databaseManager == null){
                    databaseManager = Room.databaseBuilder(context,DatabaseManager.class, MEDICAL_CENTERS_DB)
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return databaseManager;
    }
    public abstract MedicalCenterDao getMedicalCenterDao();
}
