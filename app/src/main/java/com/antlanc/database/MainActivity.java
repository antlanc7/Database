package com.antlanc.database;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static java.text.DateFormat.getDateInstance;

public class MainActivity extends Activity {

    EditText c1,c2,t;
    Button ins, view;

    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db=new DatabaseHelper(this);
        c1=findViewById(R.id.editText);
        c2=findViewById(R.id.editText2);
        t=findViewById(R.id.editText3);
        ins=findViewById(R.id.button);
        view=findViewById(R.id.button2);

        ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                sdf.setTimeZone(TimeZone.getDefault());
                String date = sdf.format(new Date());


                boolean cs=db.addRecord(date,Integer.parseInt(c1.getText().toString()),Integer.parseInt(c2.getText().toString()),Integer.parseInt(t.getText().toString()));
                if (cs) Toast.makeText(getApplicationContext(), "AGGIUNTO RECORD", Toast.LENGTH_SHORT).show();
                c1.setText("");
                c2.setText("");
                t.setText("");
            }
        });


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, DBViewer.class);
                startActivity(intent);
            }
        });
    }
}
