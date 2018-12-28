package com.antlanc.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME ="TrainMicroTuning.sqlite";
    private static final String TABLE_NAME = "Results";

    private static final String[] COLS = {"_id","DateTime","Cents1","Cents2","Time"};

    /*
    private static final String COL0 = "ID";
    private static final String COL1 = "DateTime";
    private static final String COL2 = "Cents1";
    private static final String COL3 = "Cents2";
    private static final String COL4 = "Time";
    */

    DatabaseHelper(Context context){
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COLS[0] + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLS[1] + " TEXT, " +
                COLS[2] + " INTEGER, " +
                COLS[3] + " INTEGER, " +
                COLS[4] + " INTEGER);";
        Log.d("CREAZIONE TABELLA", createTable);
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP IF TABLE EXISTS "+TABLE_NAME);
        Log.d("CREAZIONE TABELLA", "tabella già esistente");
        onCreate(db);
    }

    boolean addRecord(String date, int c1, int c2, int time){
        SQLiteDatabase db=this.getWritableDatabase();
        Log.d("DB",db.toString());
        ContentValues contentValues=new ContentValues();
        contentValues.put(COLS[1],date);
        contentValues.put(COLS[2],c1);
        contentValues.put(COLS[3],c2);
        contentValues.put(COLS[4],time);

        long success= db.insert(TABLE_NAME,null,contentValues);

        if (success>=0) Log.d("CIAO", "aggiunto record al db");
        else Log.d("MANNAGGIA", "errore nell'aggiunta del record");
        db.close();
        return (success>=0);
    }

    Cursor getData(){
        SQLiteDatabase db=this.getWritableDatabase();
        String query="SELECT * FROM "+TABLE_NAME;
        return db.rawQuery(query,null);
    }

}
