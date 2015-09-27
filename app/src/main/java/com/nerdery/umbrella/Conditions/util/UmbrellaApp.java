package com.nerdery.umbrella.Conditions.util;

import android.app.Application;
import android.content.Context;

/**
 * Created by Polycap on 9/27/2015.
 */
public class UmbrellaApp extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext(){
        return context;
    }

}
