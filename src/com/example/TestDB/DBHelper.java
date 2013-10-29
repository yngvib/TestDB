package com.example.TestDB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created with IntelliJ IDEA.
 * User: yngvi
 * Date: 29.10.13
 * Time: 16:11
 * To change this template use File | Settings | File Templates.
 */
public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "STUDENTS_DB";
    public static final int DB_VERSION = 6;

    public static final String TableStudents = "students";
    public static final String[] TableStudentsCols = { "_id", "sid", "name", "cool" };

    private static final String sqlCreateTableStudents =
            "CREATE TABLE students (" +
               "_id  INTEGER PRIMARY KEY AUTOINCREMENT," +
               "sid  INTEGER NOT NULL," +
               "name TEXT," +
               "cool INTEGER" +
            ");";
    private static final String sqlDropTableStudents =
            "DROP TABLE IF EXISTS students;";

    public DBHelper(Context context ) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL( sqlCreateTableStudents );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldV, int newV) {
        sqLiteDatabase.execSQL( sqlDropTableStudents );
        onCreate( sqLiteDatabase );
    }
}
