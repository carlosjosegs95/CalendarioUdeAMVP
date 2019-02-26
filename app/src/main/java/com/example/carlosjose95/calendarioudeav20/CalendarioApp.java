package com.example.carlosjose95.calendarioudeav20;

import android.app.Application;
import android.content.Context;

public class CalendarioApp extends Application {
    private static Context mContext;

    public static Context getmContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }
}
