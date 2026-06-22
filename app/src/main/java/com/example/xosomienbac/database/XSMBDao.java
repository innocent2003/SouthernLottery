package com.example.xosomienbac.database;

import androidx.room3.Dao;
import androidx.room3.Insert;
import androidx.room3.Query;

import com.example.xosomienbac.entities.XSMBEntity;

import java.util.List;

@Dao
public interface XSMBDao {
    @Insert
    void insert(XSMBEntity entity);

    @Insert
    void insertAll(List<XSMBEntity> list);

    @Query("SELECT * FROM xsmb_result WHERE ngay = :ngay")
    List<XSMBEntity> getByDate(String ngay);

    @Query("DELETE FROM xsmb_result WHERE ngay = :ngay")
    void deleteByDate(String ngay);
}
