package com.example.intshop.UI.Data;

import android.content.Context;
import android.content.SharedPreferences;

public class DataStuff {

    private static SharedPreferences settings = null;
    private static SharedPreferences.Editor editor = null;
    private static Context context = null;

    public static void init(Context cntxt) {
        context = cntxt;
    }

    private static void init(String category) {
        settings = context.getSharedPreferences(category, Context.MODE_PRIVATE);
        editor = settings.edit();
    }

    public static void addProperty(String category, String name, String value) {
        init(category);
        editor.putString(name, value);
        editor.apply();

    }

    public static void addIntProperty(String category, String name, Integer value) {
        init(category);
        editor.putInt(name, value);
        editor.apply();

    }

    public static String getProperty(String category, String name) {
        init(category);
        return settings.getString(name, null);
    }

    public static Integer getIntProperty(String category, String name) {
        init(category);
        return settings.getInt(name, 0);
    }

    public static void Delete(String category) {
        init(category);
        if (!category.isEmpty()) {
            editor.clear();
            editor.apply();
        }
    }
}
