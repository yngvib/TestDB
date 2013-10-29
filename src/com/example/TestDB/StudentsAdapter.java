package com.example.TestDB;

import android.content.ContentValues;
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
        String[] cols = DBHelper.TableStudentsCols;
        ContentValues contentValues = new ContentValues();
        contentValues.put( cols[1], ((Integer)sid).toString() );
        contentValues.put( cols[2], name );
        contentValues.put( cols[3], cool ? "1" : "0" );
        openToWrite();
        long value = db.insert(DBHelper.TableStudents, null, contentValues );
        close();
        return value;
    }

    public long updateStudent( int sid, String name, boolean cool ) {
        String[] cols = DBHelper.TableStudentsCols;
        ContentValues contentValues = new ContentValues();
        contentValues.put( cols[1], ((Integer)sid).toString() );
        contentValues.put( cols[2], name );
        contentValues.put( cols[3], cool ? "1" : "0" );
        openToWrite();
        long value = db.update(DBHelper.TableStudents, contentValues, cols[1] + "=" + sid, null );
        close();
        return value;
    }

    public Cursor queryStudents() {
        openToRead();
        Cursor cursor = db.query( DBHelper.TableStudents,
                                  DBHelper.TableStudentsCols, null, null, null, null, null );
        return cursor;
    }

    public Cursor queryStudent( int sid ) {
        openToRead();
        String[] cols = DBHelper.TableStudentsCols;
        Cursor cursor = db.query( DBHelper.TableStudents,
                                  cols, cols[1] + "=" + sid , null, null, null, null );
        return cursor;
    }
}
