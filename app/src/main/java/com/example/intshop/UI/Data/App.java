package com.example.intshop.UI.Data;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.intshop.UI.DataBase.UserDatabase;

public class App extends Application {
    public static App instance;

    private static Integer flag;
    private static UserDatabase db;


    @Override
    public void onCreate() {
        super.onCreate();
        db = UserDatabase.getDatabase(getApplicationContext());
        db.permsDao().update("unknown");
        Log.i("START PERMS", db.permsDao().getPerm());
    }

    public static App getInstance() {
        return instance;
    }

    public static UserDatabase getDb(){
        return db;
    }

    public static void setFlag(Integer val) {
        flag = val;
    }

    public static Integer getFlag(){
        return flag;
    }
}
