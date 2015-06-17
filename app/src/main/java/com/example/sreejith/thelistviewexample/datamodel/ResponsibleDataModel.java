package com.example.sreejith.thelistviewexample.datamodel;

import java.util.ArrayList;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Debug;
import android.widget.Toast;

/**
 * Created by Sreejith on 6/9/2015.
 */
public class ResponsibleDataModel {
    public ArrayList<String> GetAllNames(SQLiteDatabase db)
    {

        ArrayList<String> names = new ArrayList<String>();
        String query = "select * from RESPONSIBLE ";
        Cursor c = db.rawQuery(query, null);

        while(c.moveToNext())
        {
            names.add(c.getString(c.getColumnIndex("FIRST_NAME")));
        }
        c.close();
        db.close();
        return  names;
    }
    public ArrayList<ResponsibleRepository> GetAllRespobibles(SQLiteDatabase db)
    {
        ArrayList<ResponsibleRepository> responsibles = new ArrayList<ResponsibleRepository>();
        String query = "select * from RESPONSIBLE ";
        Cursor c = db.rawQuery(query, null);

        while(c.moveToNext())
        {
            ResponsibleRepository rep = new ResponsibleRepository();
            rep.FirstName = c.getString(c.getColumnIndex("FIRST_NAME"));
            rep.MiddleName = c.getString(c.getColumnIndex("MIDDLE_NAME"));
            rep.SurName = c.getString(c.getColumnIndex("SUR_NAME"));
            rep.ResponsibleId = Integer.parseInt(c.getString(c.getColumnIndex("RESPONSIBLE_ID")));
            responsibles.add(rep);
        }
        c.close();
        db.close();
        return responsibles;
    }

    public boolean UpdateResponsible(SQLiteDatabase db, ResponsibleRepository repo)
    {
        boolean result = false;
        try {
            String sql = "Update RESPONSIBLE set FIRST_NAME = '" + repo.FirstName + "', " +
                    "MIDDLE_NAME = '" + repo.MiddleName + "', " +
                    "SUR_NAME = '" + repo.SurName + "' " +
                    "WHERE RESPONSIBLE_ID = " + repo.ResponsibleId;


            db.execSQL(sql);
            db.close();
            result = true;
        }
        catch (Exception ex)
        {
            result = false;
        }

        return  result;
    }
}
