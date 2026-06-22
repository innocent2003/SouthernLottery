package com.example.xosomienbac.database;


import android.content.Context;

import androidx.room3.Database;
import androidx.room3.Room;
import androidx.room3.RoomDatabase;

import com.example.xosomienbac.entities.XSMBEntity;

@Database(
        entities = {XSMBEntity.class},
        version = 1,
        exportSchema = false
)
public abstract class AppDatabase
        extends RoomDatabase {

    public abstract XSMBDao xsmbDao();

    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getInstance(
            Context context) {

        if (INSTANCE == null) {

            synchronized (AppDatabase.class) {

                if (INSTANCE == null) {

                    INSTANCE =
                            Room.databaseBuilder(
                                    context.getApplicationContext(),
                                    AppDatabase.class,
                                    "xoso_db"
                            ).build();
                }
            }
        }

        return INSTANCE;
    }
}
