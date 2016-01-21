package com.hai;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;

import com.hai.utils.MyLog;
import com.hai.utils.SDCardUtils;

public class MainActivity extends AppCompatActivity {
    private String tag = "hhp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testSd();
    }

    public void testSd() {
        MyLog.d(getCacheDir().getAbsolutePath());
        MyLog.d(SDCardUtils.isSDCardEnable() + "");
        MyLog.d(Environment.getExternalStorageDirectory().getAbsolutePath());
    }

}
