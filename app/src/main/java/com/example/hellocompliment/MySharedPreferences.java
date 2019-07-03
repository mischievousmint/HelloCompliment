package com.example.hellocompliment;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class MySharedPreferences {

    private  static SharedPreferences mySharedPref;
    static final String KEYNAME = "nombre";
    static final String PASSWORD = "password";

    private MySharedPreferences() {

    }

    public static void  init (Context context) {
        if(mySharedPref == null) {
            mySharedPref = context.getSharedPreferences("MYPREFS", Activity.MODE_PRIVATE); //MYPREFS es el nombre del a BBDD
        }
    }

    public static void  saveName(String name) {
        SharedPreferences.Editor prefsEditor = mySharedPref.edit();
        prefsEditor.putString(KEYNAME, name);
        prefsEditor.apply();
    }

    public static String loadName() {
        return  mySharedPref.getString(KEYNAME, "");
    }


    public static void  savePassword(String name) {
        SharedPreferences.Editor prefsEditor = mySharedPref.edit();
        prefsEditor.putString(PASSWORD, name);
        prefsEditor.apply();
    }

    public static String loadPassword() {
        return  mySharedPref.getString(PASSWORD, "");
    }
}
