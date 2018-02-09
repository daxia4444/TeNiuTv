package com.example.shutao.teniutv.app;

import com.example.shutao.teniutv.app.base.BaseApp;
import com.socks.library.KLog;

import org.litepal.LitePalApplication;

/**
 * Created by Administrator on 2018/2/8.
 */

public class MyApp extends BaseApp {

    @Override
    public void onCreate() {
        super.onCreate();

        //**************************************相关第三方SDK的初始化等操作*************************************************
        KLog.init(BuildConfig.DEBUG);//初始化KLog
        LitePalApplication.initialize(getApplicationContext());//初始化litePal
    }
}