package com.example.TestDB;

import android.*;
import android.R;
import android.app.Activity;
import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.SimpleCursorAdapter;

/**
 * Created with IntelliJ IDEA.
 * User: yngvi
 * Date: 29.10.13
 * Time: 16:07
 * To change this template use File | Settings | File Templates.
 */
public class StudentsActivity extends ListActivity {

    private StudentsAdapter mStudentsAdapter = new StudentsAdapter( this );
    private SimpleCursorAdapter mCursorAdapter;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Cursor cursor = mStudentsAdapter.queryStudents();
        String from[] = { "name" };
        int to[] = { R.id.text1 };
        startManagingCursor( cursor );
        mCursorAdapter = new SimpleCursorAdapter(this, R.layout.simple_list_item_1, cursor, from, to );
        setListAdapter( mCursorAdapter );
    }

    protected void onRestart() {
        super.onRestart();
        mCursorAdapter.getCursor().requery();
    }

    protected void onDestroy() {
        super.onDestroy();
        mStudentsAdapter.close();
    }

}