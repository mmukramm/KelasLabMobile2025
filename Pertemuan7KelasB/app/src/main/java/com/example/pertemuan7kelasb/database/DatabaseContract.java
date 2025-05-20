package com.example.pertemuan7kelasb.database;

import android.provider.BaseColumns;

public class DatabaseContract {
    public static String TABLE_NAME = "student";

    public static final class StudentColumn implements BaseColumns{
        public static String NAME = "name";
        public static String NIM = "nim";
    }
}
