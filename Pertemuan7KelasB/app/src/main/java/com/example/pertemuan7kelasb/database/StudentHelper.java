package com.example.pertemuan7kelasb.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class StudentHelper {
    public static String TABLE_NAME = DatabaseContract.TABLE_NAME;
    public static DatabaseHelper databaseHelper;
    public static SQLiteDatabase sqLiteDatabase;

    public static volatile StudentHelper INSTANCE;

    public static StudentHelper getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (SQLiteOpenHelper.class) {
                if (INSTANCE == null) {
                    INSTANCE = new StudentHelper(context);
                }
            }
        }
        return INSTANCE;
    }

    public StudentHelper(Context context) {
        databaseHelper = new DatabaseHelper(context);
    }

    public void open() throws SQLException {
        sqLiteDatabase = databaseHelper.getWritableDatabase();
    }

    public void close() {
        databaseHelper.close();
        if (sqLiteDatabase.isOpen()) {
            sqLiteDatabase.close();
        }
    }


    public Cursor queryAll() {
        return sqLiteDatabase.query(
                TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                DatabaseContract.StudentColumn._ID + " ASC"
        );
    }


    public Cursor queryById(String id) {
        return sqLiteDatabase.query(
                TABLE_NAME,
                null,
                DatabaseContract.StudentColumn._ID + " = ?",
                new String[]{id},
                null,
                null,
                null,
                null
        );
    }


    public long insert(ContentValues values) {
        return sqLiteDatabase.insert(TABLE_NAME, null, values);
    }


    public int update(String id, ContentValues values) {
        return sqLiteDatabase.update(TABLE_NAME, values, DatabaseContract.StudentColumn._ID
                + " = ?", new String[]{id});
    }


    public int deleteById(String id) {
        return sqLiteDatabase.delete(TABLE_NAME, DatabaseContract.StudentColumn._ID + " = ?",
                new String[]{id});
    }
}
