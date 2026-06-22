package com.example.xosomienbac.entities;

import androidx.room3.Entity;
import androidx.room3.PrimaryKey;

@Entity(tableName = "xsmb_result")
public class XSMBEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String ngay;

    public String prize;

    public String values;
}
