package com.antlanc.database;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class DBAdapter extends CursorAdapter {

    DBAdapter(Context context, Cursor c) {
        super(context, c, false);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.row_adapter, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView[] tvs = {view.findViewById(R.id.textViewDate),
                view.findViewById(R.id.textViewSound1),
                view.findViewById(R.id.textViewSound2),
                view.findViewById(R.id.textViewTime)};
        int i = 0;
        for (TextView tv : tvs) {
            i++;
            tv.setText(cursor.getString(i));
        }
    }
}
