package com.example.sreejith.thelistviewexample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Sreejith on 6/8/2015.
 */
class DBOperations extends SQLiteOpenHelper {

    private static final String TAG = DBOperations.class.getName();
    public static final String DATABASE_NAME = "MyDb.db";
    public static final int DATABASE_VERSION = 1;

    Context context;

    public DBOperations(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String  qry = "CREATE TABLE  RESPONSIBLE "
                + " ( " + "_id" + " INTEGER  PRIMARY KEY AUTOINCREMENT,"
                + " RESPONSIBLE_ID " + " varchar(10),"
                + " CODE " + " varchar(10),"
                + " FIRST_NAME " + " TEXT not null,"
                + " MIDDLE_NAME " + " TEXT not null,"
                + " SUR_NAME " + " TEXT not null" + ");";

        sqLiteDatabase.execSQL(qry);

        qry = "Delete From RESPONSIBLE";
        sqLiteDatabase.execSQL(qry);

        qry = "insert into RESPONSIBLE (RESPONSIBLE_ID, CODE, FIRST_NAME, MIDDLE_NAME, SUR_NAME) values ( 1, '10001', 'Renjith', 'Gopi', 'Pillai') ";
        sqLiteDatabase.execSQL(qry);
        qry = "insert into RESPONSIBLE (RESPONSIBLE_ID, CODE, FIRST_NAME, MIDDLE_NAME, SUR_NAME) values ( 2, '10002', 'Priyesh', 'P', 'G') ";
        sqLiteDatabase.execSQL(qry);

        qry = "insert into RESPONSIBLE (RESPONSIBLE_ID, CODE, FIRST_NAME, MIDDLE_NAME, SUR_NAME) values ( 3, '10003', 'Bobby', 'Panaparambil', 'Thampy') ";
        sqLiteDatabase.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
