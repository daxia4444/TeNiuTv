package com.example.shutao.teniutv.app;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

/**
 * Created by shutao on 2018/2/11.
 */

public class MyApp extends Application {

    private static Handler mHandler;//主线程Handler

    @Override
    public void onCreate() {
        super.onCreate();
        mHandler = new Handler();

    }

    public static Handler getMainHandler() {
        return mHandler;
    }

}
