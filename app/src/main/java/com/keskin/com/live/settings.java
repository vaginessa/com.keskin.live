package com.keskin.com.live;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;

public class settings extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        SharedPreferences read = getSharedPreferences("renk",MODE_PRIVATE);
        EditText red = (EditText) findViewById(R.id.red);
        EditText blue = (EditText) findViewById(R.id.blue);
        EditText green = (EditText) findViewById(R.id.green);
        EditText alpha = (EditText) findViewById(R.id.alpha);
        alpha.setText(Integer.toString(read.getInt("a",255)));
        red.setText(Integer.toString(read.getInt("r",255)));
        green.setText(Integer.toString(read.getInt("g",255)));
        blue.setText(Integer.toString(read.getInt("b",255)));


    }
    public void ayarla(View view){

        SharedPreferences.Editor edit = getSharedPreferences("renk",MODE_PRIVATE).edit();
        EditText red = (EditText) findViewById(R.id.red);
        EditText blue = (EditText) findViewById(R.id.blue);
        EditText green = (EditText) findViewById(R.id.green);
        EditText alpha = (EditText) findViewById(R.id.alpha);
        edit.putInt("a",Integer.parseInt(alpha.getText().toString()));
        edit.putInt("r",Integer.parseInt(red.getText().toString()));
        edit.putInt("g",Integer.parseInt(green.getText().toString()));
        edit.putInt("b",Integer.parseInt(blue.getText().toString()));
        edit.commit();
    }

}
