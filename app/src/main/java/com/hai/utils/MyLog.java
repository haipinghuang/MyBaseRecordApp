package com.hai.utils;

import android.util.Log;

/**
 * User: huanghai
 * date：2015/8/28
 */
public class MyLog {
    private static final String TAG = "hhp";

    public static void d(String tag, String content) {
        Log.d(TAG, tag + "== " + content);
    }

    public static void d(String content) {
        Log.d(TAG, content + "");
    }
}
