package com.example.pertemuan7kelasb;

import android.database.Cursor;

import com.example.pertemuan7kelasb.database.DatabaseContract;

import java.util.ArrayList;

public class MappingHelper {
    public static ArrayList<Student> mapCursorToArrayList(Cursor cursor) {
        ArrayList<Student> students = new ArrayList<>();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseContract.StudentColumn._ID));
            String name = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.StudentColumn.NAME));
            String nim = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.StudentColumn.NIM));
            students.add(new Student(id, name, nim));
        }
        return students;
    }
}
