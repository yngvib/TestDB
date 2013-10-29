package com.example.TestDB;

import android.content.Context;
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


}
