package com.example.spotrkom.data.user;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.spotrkom.pojo.UserModel;


@Database(entities = {UserModel.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static final Object LOCK = new Object();
    private static AppDatabase database;
    private static final String DB_NAME = "sportkom.db";

    public static AppDatabase getInstance(Context context){

        synchronized (LOCK) {
            if (database == null){
                database = Room.databaseBuilder(context, AppDatabase.class, DB_NAME)
                        .build();
            }
        }
        return database;
    }

    public abstract UserDao userDao();

}
