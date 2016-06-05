package com.hai;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hai.utils.MyLog;
import com.hai.utils.SDCardUtils;

public class MainActivity extends AppCompatActivity {
    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testSd();
//        testThrows();
    }

    public void btn(View v) {
        Object o = null;
        String s = o.toString();
    }

    private void testThrows() {
        int[] ins = new int[]{1, 2, 3};
        int i = 6 / 0;
    }

    public void testSd() {
        MyLog.d(getCacheDir().getAbsolutePath());
        MyLog.d(SDCardUtils.isSDCardEnable() + "");
        MyLog.d(Environment.getExternalStorageDirectory().getAbsolutePath());
    }

}
