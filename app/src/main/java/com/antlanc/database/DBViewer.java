package com.antlanc.database;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class DBViewer extends Activity {

    ListView listView;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbviewer);


        db=new DatabaseHelper(this);
        Cursor data=db.getData();

        /*  VISUALIZZATORE D'EMERGENZA DATABASE: NON FA USO DELLA LISTVIEW MA VISUALIZZA IN UN POPUP
        StringBuffer buffer = new StringBuffer();
        data.moveToFirst();
        while (!data.isAfterLast()) {
            buffer.append(data.getColumnName(0) + " : " + data.getString(0)+"\n");
            buffer.append(data.getColumnName(1) + " : " + data.getString(1)+"\n");
            buffer.append(data.getColumnName(2) + " : " + data.getString(2)+"\n");
            buffer.append(data.getColumnName(3) + " : " + data.getString(3)+"\n");
            buffer.append(data.getColumnName(4) + " : " + data.getString(4)+"\n\n");
            data.moveToNext();
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("Database");
        builder.setMessage(buffer.toString());
        builder.show();
        */

        DBAdapter dbAdapter = new DBAdapter(this,data);
        listView=findViewById(R.id.listView);
        listView.setAdapter(dbAdapter);


    }
}
