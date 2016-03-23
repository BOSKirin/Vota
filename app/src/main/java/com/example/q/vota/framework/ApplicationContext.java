package com.example.q.vota.framework;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

import com.example.q.vota.util.DatabaseHelper;


/**
 * Created by Q on 3/22/16.
 */
public class ApplicationContext extends Application {

    private static Context context = null;
    private static DatabaseHelper dbHelper;

    public void onCreate(){
        super.onCreate();

        context = this.getApplicationContext();

        dbHelper = new DatabaseHelper(context);


    }

    public void onTerminate(){
        super.onTerminate();
    }

    public static Context getContext(){
        return context;
    }


    public synchronized static void saveContext(){
        if(dbHelper == null){
            dbHelper = new DatabaseHelper(context);
        }
    }

    public static boolean isOfflineMode(){
        return false;
    }

    public static String getLocalFileDir(Context adapter) {
        return adapter.getFilesDir().getAbsolutePath();
    }

    public static String getLocalImgDir(Context adapter) {
        return getLocalFileDir(adapter)+"/img";
    }

    public static String getValidLocale(String locale){
        String value = "en";

        if(!TextUtils.isEmpty(locale) && locale.equalsIgnoreCase("es")){
            value = "es";
        }

        return value;
    }

    private String getVersionWithoutChar(String str){
        String version = "";

        if(!TextUtils.isEmpty(str)){
            if(TextUtils.isDigitsOnly(str.substring(str.length() - 1))){
                version = str;
            }else{
                version = str.substring(0, str.length() - 1);
            }
        }

        return version;
    }

}
