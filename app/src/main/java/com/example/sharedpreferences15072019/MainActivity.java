package com.example.sharedpreferences15072019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.StringBufferInputStream;

public class MainActivity extends AppCompatActivity {
    EditText editText,editText2;
    Button button,button2,button3;
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.editText);
        editText2=findViewById(R.id.editText2);
        button=findViewById(R.id.button);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        pref=getSharedPreferences("myfile", Context.MODE_PRIVATE); //an xml file will be created internally we cant see in phone and mode_PRIVATE  means no other app can access this app data
        editor=pref.edit();
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String d=editText.getText().toString().trim();
                String w=editText2.getText().toString().trim();
                editor.putString("date_key", d);
                editor.putString("weather_key",w);
                editor.commit();
                Toast.makeText(MainActivity.this,"data Saved...",Toast.LENGTH_LONG).show();
                editText.setText("");
                editText2.setText("");

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String d= pref.getString("date_key",null);
                String w= pref.getString("weather_key",null);
                Toast.makeText(MainActivity.this,d+"\n"+w,Toast.LENGTH_LONG).show();

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                editor.remove("date_key");
                //editor.clear();
                editor.commit();
            }
        });
    }
}
