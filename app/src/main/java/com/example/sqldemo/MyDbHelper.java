package com.example.sqldemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDbHelper extends SQLiteOpenHelper {
    public static final String CREATE_BOOK = "create table Book	(" +
            "id	integer	primary	key	autoincrement,	"
            + "author	text,	"
            + "price	real,	"
            + "pages	integer,	"
            + "name text)";
    public static final String CREATE_CATA = "create table Catalgory(" +
            "\n" +
            "id  integer primary key autoincrement ,    " +
            "\n" +
            "cata_name text ,\n" +
            "\n" +
            "cata_code  integer\n" +
            "\n" +
            ")";
    Context mContext;

    public MyDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BOOK);
        db.execSQL(CREATE_CATA);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop	table	if	exists	Book");
        db.execSQL("drop	table	if	exists	Catalgory");
        onCreate(db);
    }
}
