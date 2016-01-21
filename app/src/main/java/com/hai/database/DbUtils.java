package com.hai.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;

/**
 * 数据库操作工具
 * Created by 黄海 on 2015/10/13.
 */
public class DbUtils {
    private static DbUtils mInstance;
    private SQLiteDatabase mSqLiteDatabase;

    public static DbUtils getInstance(String dbFilePath) {
        return new DbUtils(dbFilePath);
    }

    public static DbUtils getInstance() {
        return mInstance;
    }

    private DbUtils(String filePath) {
        if (TextUtils.isEmpty(filePath)) {
            throw new IllegalArgumentException("file path can not be null");
        }
        mInstance = this;
        mSqLiteDatabase = SQLiteDatabase.openDatabase(filePath, null, SQLiteDatabase.CREATE_IF_NECESSARY);
    }

    private void close() {
        if (mSqLiteDatabase != null && mSqLiteDatabase.isOpen()) {
            mSqLiteDatabase.close();
        }
        mInstance = null;
    }

    public boolean execSQL(String sql) {
        boolean flag = false;
        try {
            mSqLiteDatabase.execSQL(sql);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return flag;
    }

    /**
     * 查询须手动关闭数据库
     *
     * @param table
     * @param columns
     * @param selection
     * @param selectionArgs
     * @return
     */
    public Cursor query(String table, String[] columns, String selection,
                        String[] selectionArgs) {
        return query(table, columns, selection, selectionArgs, null, null, null);
    }

    public Cursor query(String table, String[] columns, String selection,
                        String[] selectionArgs, String groupBy, String having,
                        String orderBy) {
        return mSqLiteDatabase.query(table, columns, selection, selectionArgs, groupBy, having, orderBy);
    }

    public long insert(String table, String nullColumnHack, ContentValues values) {
        Long id = mSqLiteDatabase.insert(table, nullColumnHack, values);
        close();
        return id;
    }

    public long insert(String table, ContentValues values) {
        return insert(table, null, values);
    }

}
