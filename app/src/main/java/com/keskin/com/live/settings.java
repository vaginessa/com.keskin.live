package com.keskin.com.live;

import android.app.WallpaperManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

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

        Button tg = (Button) findViewById(R.id.regular);
        LinearLayout linear =(LinearLayout) findViewById(R.id.linear);
        if (tg.getText() == "MOD:Düzenli Renkler")
        {
            linear.setVisibility(View.INVISIBLE);
        }
        else
        {
            linear.setVisibility(View.VISIBLE);
         }

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

    public void duzenli(View view){
        Button tg = (Button) findViewById(R.id.regular);
        SharedPreferences.Editor edit = getSharedPreferences("renk",MODE_PRIVATE).edit();
        LinearLayout linear =(LinearLayout) findViewById(R.id.linear);
        if (tg.getText() == "MOD:Düzenli Renkler")
        {
            tg.setText("MOD:Rastgele Renkler");
            linear.setVisibility(View.VISIBLE);
            edit.putInt("regular",0);
            edit.commit();
        }
        else
        {
            tg.setText("MOD:Düzenli Renkler");
            linear.setVisibility(View.INVISIBLE);
            edit.putInt("regular",1);
            edit.commit();
        }
        Intent intent = new Intent(
                WallpaperManager.ACTION_CHANGE_LIVE_WALLPAPER);
        intent.putExtra(WallpaperManager.EXTRA_LIVE_WALLPAPER_COMPONENT,
                new ComponentName(this, wallactivity.class));
        startActivity(intent);
    }
}
