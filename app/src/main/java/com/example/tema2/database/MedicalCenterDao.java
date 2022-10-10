package com.example.tema2.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.tema2.classes.MedicalCenter;

import java.util.List;

@Dao
public interface MedicalCenterDao {
    @Insert
    long insert(MedicalCenter medicalCenter);

    @Query("select * from `Medical Centers`")
    List<MedicalCenter> getAll();
}
