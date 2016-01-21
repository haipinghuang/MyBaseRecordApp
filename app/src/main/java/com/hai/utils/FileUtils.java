package com.hai.utils;

import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by 黄海 on 2015/10/13.
 */
public class FileUtils {
    public static boolean saveToFile(String content) {
        boolean flag = false;
        content += "\r\n";
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()
                + "/logcat/myLog.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file, true);
            fos.write(content.getBytes());
            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (null!=fos){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }
}
