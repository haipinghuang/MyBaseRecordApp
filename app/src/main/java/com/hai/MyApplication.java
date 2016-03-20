package com.hai;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.StrictMode;

/**
 * Created by 黄海 on 2016/3/1.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        setStrictMode();
    }

    /**
     * 用来帮助开发者发现代码中的一些不规范的问题。比如，如果你在UI线程中进行了网络或者磁盘操作，
     * StrictMode就会通过Log（logcat ）或者对话框的方式把信息提示给你，因为让你的UI线程处理这里
     * 操作会被认为是不规范的做法，可能会让你的应用变得比较卡顿。
     */
    private void setStrictMode() {
        int appFlags = getApplicationInfo().flags;
        if ((appFlags & ApplicationInfo.FLAG_DEBUGGABLE) !=
                0 && Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {

            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectAll().penaltyDialog().penaltyLog().build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectAll().penaltyDeath().build());
        }
    }
}
