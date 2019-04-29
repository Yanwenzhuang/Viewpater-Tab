package com.example.wechat_app.util;

import android.nfc.Tag;
import android.os.Build;
import android.util.Log;

import com.example.wechat_app.BuildConfig;

public class L {

    private static final String TAG = "fyman";
    private static boolean sDebug = BuildConfig.DEBUG;

    public static void d(String msg,Object... args){
        if(!sDebug){
            return;
        }
        Log.d(TAG,String.format(msg,args));
    }
}
