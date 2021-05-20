package com.example.projekti_3.preferences;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {

    public static String SHARED_PREFERENCES = "com.example.projekti_3";

    public static SharedPreferences getPrefs(Context context){
        return context.getSharedPreferences(SHARED_PREFERENCES,Context.MODE_PRIVATE);
    }


    public static void saveBoolean(Context context, String key, boolean value){
        getPrefs(context).edit().putBoolean(key,value).apply();
    }

    public static boolean getBoolean(Context context, String key){
        return getPrefs(context).getBoolean(key,false);
    }

    public static void saveString(Context context, String key, String value){
        getPrefs(context).edit().putString(key,value).apply();
    }

    public static String getString(Context context, String key){
        return getPrefs(context).getString(key,"");
    }

    public static void saveDouble(Context context, String key, double value){
        getPrefs(context).edit().putLong(key, (long) value).apply();
    }

    public static double getDouble(Context context, String key){
        return getPrefs(context).getLong(key,0);
    }


}
