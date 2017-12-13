package com.it.personal.base;

import android.app.Application;
import android.content.Context;

/**
 * Created by 唐卓 on 2017/12/8.
 * 程序入口函数
 */

public class ApplicationApp extends Application {

    public static Context globalContext;

    @Override
    public void onCreate() {
        super.onCreate();
        globalContext = this;

    }
}
