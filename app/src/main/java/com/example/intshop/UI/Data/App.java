package com.example.intshop.UI.Data;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.intshop.UI.DataBase.UserDatabase;
import com.example.intshop.UI.Ui.Korsina;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App extends Application {
    public static App instance;

    private static Integer flag = 0;
    private static UserDatabase db;

    private static String Perms;


    @Override
    public void onCreate() {
        super.onCreate();
        Perms = "unknown";
        DataStuff.init(this);
        DataStuff.Delete("Korsina");
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

    public static void setPerms(String val){
        Perms = val;
    }

    public static String getPerms(){
        return Perms;
    }

}
