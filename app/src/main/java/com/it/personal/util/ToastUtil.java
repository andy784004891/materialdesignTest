package com.it.personal.util;

import android.widget.Toast;

import com.it.personal.base.ApplicationApp;

/**
 * Created by tangzhuo on 2017/12/11.
 *
 */

public class ToastUtil {

    private static Toast toast;

    public static void show(String text){
        if (toast == null) {
            toast = Toast.makeText(ApplicationApp.globalContext, text, Toast.LENGTH_SHORT);
        }else {
            toast.setText(text);
        }
        toast.show();
    }
}
