package com.example.pauls.leaguetable;

/**
 * Created by Pauls on 23/11/2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class helper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "League.db";
    public static final String TABLE_NAME = "LeagueTable";
    public static final String COL_1 = "PLAYERID";
    public static final String COL_2 = "PLAYER";
    public static final String COL_3 = "TEAM";
    public static final String COL_4 = "GAMESPLAYED";
    public static final String COL_5 = "GOALSFOR";
    public static final String COL_6 = "GOALSAGAINST";
    public static final String COL_7 = "GOALDIFFERENCE";
    public static final String COL_8 = "POINTS";

    public helper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (PLAYERID INTEGER PRIMARY KEY AUTOINCREMENT,PLAYER TEXT,TEAM TEXT," +
                "GAMESPLAYED INTEGER,GOALSFOR INTEGER,GOALSAGAINST INTEGER,GOALDIFFERENCE INTEGER,POINTS INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String player,String team,String gamesplayed,String goalsfor,String goalsagainst,
                              String goaldifference, String points ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,player);
        contentValues.put(COL_3,team);
        contentValues.put(COL_4,gamesplayed);
        contentValues.put(COL_5,goalsfor);
        contentValues.put(COL_6,goalsagainst);
        contentValues.put(COL_7,goaldifference);
        contentValues.put(COL_8,points);
        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    public boolean updateData(String id,String player,String team,String gamesplayed,String goalsfor,String goalsagainst,
                              String goaldifference, String points )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1,id);
        contentValues.put(COL_2,player);
        contentValues.put(COL_3,team);
        contentValues.put(COL_4,gamesplayed);
        contentValues.put(COL_5,goalsfor);
        contentValues.put(COL_6,goalsagainst);
        contentValues.put(COL_7,goaldifference);
        contentValues.put(COL_8,points);
        db.update(TABLE_NAME, contentValues, "PLAYERID = ?",new String[] {id});
        return true;
    }

    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        //? asks what is the id
        return db.delete(TABLE_NAME, "PLAYERID = ?",new String[] {id});
    }
}
