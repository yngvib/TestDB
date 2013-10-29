package com.example.TestDB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created with IntelliJ IDEA.
 * User: yngvi
 * Date: 29.10.13
 * Time: 16:26
 * To change this template use File | Settings | File Templates.
 */
public class StudentsAdapter {

    SQLiteDatabase db;
    DBHelper dbHelper;
    Context  context;

    StudentsAdapter( Context c ) {
        context = c;
    }

    public StudentsAdapter openToRead() {
        dbHelper = new DBHelper( context );
        db = dbHelper.getReadableDatabase();
        return this;
    }

    public StudentsAdapter openToWrite() {
        dbHelper = new DBHelper( context );
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        db.close();
    }

    public long insertStudent( int sid, String name, boolean cool ) {
        return 0;
    }

    public long updateStudent( int sid, String name, boolean cool ) {
        return 0;
    }

    public Cursor queryStudents() {
        openToRead();
        Cursor cursor = db.query( DBHelper.TableStudents,
                                  DBHelper.TableStudentsCols, null, null, null, null, null );
        return cursor;
    }

    public Cursor queryStudent( int sid ) {
        return null;
    }
}
